package org.example.ch12_swing.sec_05_new_swing_functionality_in_java7;

import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.beans.PropertyChangeEvent;

class FirstLayerUI extends LayerUI<JComponent> {
    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        var g2 = (Graphics2D) g.create();
        // 设置透明效果
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));
        // 使用渐变画笔绘图
        g2.setPaint(new GradientPaint(0, 0, Color.RED, 0, c.getHeight(), Color.BLUE));
        // 绘制一个与被装饰组件具有相同大小的组件
        g2.fillRect(0, 0, c.getWidth(), c.getHeight());
        g2.dispose();
    }
}

class BlurLayerUI extends LayerUI<JComponent> {
    private BufferedImage screenBlurImage;
    private BufferedImageOp operation;

    public BlurLayerUI() {
        var ninth = 1.0f / 9.0f;
        // 定义模糊参数
        float[] blurKernel = {
                ninth, ninth, ninth,
                ninth, ninth, ninth,
                ninth, ninth, ninth
        };
        // ConvolveOp代表一个模糊定义，它将 原图片的每一个像素与周围
        // 像素的颜色进行混合，从而计算出当前像素的颜色值
        operation = new ConvolveOp(
                new Kernel(3, 3, blurKernel),
                ConvolveOp.EDGE_NO_OP, null);
    }

    public void paint(Graphics g, JComponent c) {
        var w = c.getWidth();
        var h = c.getHeight();
        // 如果被装饰窗口大小为0x0, 直接返回
        if (w == 0 || h == 0)
            return;
        // 如果screenBlurImage没有初始化,或它的尺寸不对
        if (screenBlurImage == null
                || screenBlurImage.getWidth() != w
                || screenBlurImage.getHeight() != h) {
            // 重新创建新的BufferedImage
            screenBlurImage = new BufferedImage(w,
                    h, BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D ig2 = screenBlurImage.createGraphics();
        // 把被装饰组件的界面绘制到当前screenBlurImage上
        ig2.setClip(g.getClip());
        super.paint(ig2, c);
        ig2.dispose();
        var g2 = (Graphics2D) g;
        // 对JLayer装饰的组件进行模糊处理
        g2.drawImage(screenBlurImage, operation, 0, 0);
    }
}

class SpotlightLayerUI extends LayerUI<JComponent> {
    private boolean active;
    private int cx, cy;

    public void installUI(JComponent c) {
        super.installUI(c);
        var layer = (JLayer) c;
        // 设置JLayer可以响应鼠标事件和鼠标动作事件
        layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
    }

    public void uninstallUI(JComponent c) {
        var layer = (JLayer) c;
        // 设置JLayer不响应任何事件
        layer.setLayerEventMask(0);
        super.uninstallUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        var g2 = (Graphics2D) g.create();
        super.paint(g2, c);
        // 如果处于激活状态
        if (active) {
            // 定义一个cx, cy位置的点
            Point2D center = new Point2D.Float(cx, cy);
            float radius = 72;
            float[] dist = {0.0f, 1.0f};
            Color[] colors = {Color.YELLOW, Color.BLACK};
            // 以center为中心，colors为颜色数组创建环形渐变
            var p = new RadialGradientPaint(center, radius, dist, colors);
            g2.setPaint(p);
            // 设置渐变效果
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .6f));
            // 绘制矩形
            g2.fillRect(0, 0, c.getWidth(), c.getHeight());
        }
        g2.dispose();
    }

    // 处理鼠标事件的方法
    public void processMouseEvent(MouseEvent e, JLayer layer) {
        if (e.getID() == MouseEvent.MOUSE_ENTERED)
            active = true;
        if (e.getID() == MouseEvent.MOUSE_EXITED)
            active = false;
        layer.repaint();
    }

    // 处理鼠标动作事件的方法
    public void processMouseMotionEvent(MouseEvent e, JLayer layer) {
        Point p = SwingUtilities.convertPoint(
                e.getComponent(), e.getPoint(), layer);
        // 获取鼠标动作事件发生点的坐标
        cx = p.x;
        cy = p.y;
        layer.repaint();
    }
}

class WaitingLayerUI extends LayerUI<JComponent> {
    private boolean isRunning;
    private Timer timer;
    // 记录转过的角度
    private int angle;

    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        int w = c.getWidth();
        int h = c.getHeight();
        // 已经停止运行，直接返回
        if (!isRunning)
            return;
        var g2 = (Graphics2D) g.create();
        Composite urComposite = g2.getComposite();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));
        // 填充矩形
        g2.fillRect(0, 0, w, h);
        g2.setComposite(urComposite);
        // -----下面代码开始绘制转动的"齿轮"-----
        // 计算得到宽、高中较小值的1/5
        var s = Math.min(w, h) / 5;
        var cx = w / 2;
        var cy = h / 2;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 设置笔触
        g2.setStroke(new BasicStroke(s / 2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g2.setPaint(Color.BLUE);
        // 画笔绕被装饰组件的中心转过angle度
        g2.rotate(Math.PI * angle / 180, cx, cy);
        // 循环绘制12条线条，形成"齿轮"
        for (var i = 0; i < 12; i++) {
            float scale = (11.0f - (float) i) / 11.0f;
            g2.drawLine(cx + s, cy, cx + s * 2, cy);
            g2.rotate(-Math.PI / 6, cx, cy);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, scale));
        }
        g2.dispose();
    }

    // 控制等待(齿轮开始转动)的方法
    public void start() {
        // 如果已经在运行中，直接返回
        if (isRunning)
            return;
        isRunning = true;
        // 每隔0.1秒重绘一次
        timer = new Timer(100, e -> {
            if (isRunning) {
                // 触发applyPropertyChange()方法，让JLayer重绘制
                // 在这行代码中，后面两个参数没有意义
                firePropertyChange("crazyitFlag", 0, 1);
                // 角度加6
                angle += 6;
                // 到达360角度后再从0开始
                if (angle >= 360)
                    angle = 0;
            }
        });
        timer.start();
    }

    // 控制停止等待(齿轮停止转动)的方法
    public void stop() {
        isRunning = false;
        // 最后通知JLayer重绘一次，清楚曾经绘制的图形
        firePropertyChange("crazyitFlag", 0, 1);
        timer.stop();
    }

    @Override
    public void applyPropertyChange(PropertyChangeEvent pce, JLayer<? extends JComponent> layer) {
        // 控制JLayer重绘
        if (pce.getPropertyName().equals("crazyitFlag")) {
            layer.repaint();
        }
    }
}

public class A_JLayerTest {
    public void init() {
        var f = new JFrame("JLayer测试");
        var p = new JPanel();
        var group = new ButtonGroup();
        JRadioButton radioButton;
        // 创建3个RadioButton, 并将它们添加成一组
        p.add(radioButton = new JRadioButton("网购购买", true));
        group.add(radioButton);
        p.add(radioButton = new JRadioButton("书店购买"));
        group.add(radioButton);
        p.add(radioButton = new JRadioButton("图书馆借阅"));
        group.add(radioButton);
        // 添加3个JCheckbox
        p.add(new JCheckBox("疯狂Java讲义"));
        p.add(new JCheckBox("疯狂Android讲义"));
        p.add(new JCheckBox("疯狂Ajax讲义"));
        p.add(new JCheckBox("轻量级 Java EE企业应用"));
        var orderButton = new JButton("投票");


        p.add(orderButton);
        // 创建LayerUI对象
        // LayerUI<JComponent> layerUI = new FirstLayerUI();
        // LayerUI<JComponent> layerUI = new BlurLayerUI();
        // LayerUI<JComponent> layerUI = new SpotlightLayerUI();
        var layerUI = new WaitingLayerUI();
        // 设置4秒之后执行指定动作，定义layerUI的stop()方法
        final Timer stopper = new Timer(4000, ae -> layerUI.stop());
        // 设置stopper定时器只触发一次
        stopper.setRepeats(false);
        // 为orderButton绑定事件监听器，单击该按钮时，调用layerUI的start()方法
        orderButton.addActionListener(ae -> {
            layerUI.start();
            // 如果stopper定时器已经停止，则启动它
            if (!stopper.isRunning()) {
                stopper.start();
            }
        });

        // 使用layerUI来装饰指定的JPanel组件
        var layer = new JLayer<JComponent>(p, layerUI);
        // 将装饰后的JPanel组件添加到容器中
        f.add(layer);
        f.setSize(300, 170);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new A_JLayerTest().init();
    }
}
