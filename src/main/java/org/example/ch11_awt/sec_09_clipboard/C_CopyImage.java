package org.example.ch11_awt.sec_09_clipboard;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class C_CopyImage {
    // 系统剪贴板
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    // 使用ArrayList来保存所有黏贴进来的Image--就是当成图层处理
    List<Image> imageList = new ArrayList<>();
    // 画图区的宽度
    private final int AREA_WIDTH = 500;
    // 画图区的高度
    private final int AREA_HEIGHT = 400;
    // 下面的preX, preY保存了上一次鼠标拖动事件的鼠标坐标
    private int preX = -1;
    private int preY = -1;
    // 定义一个右键菜单用于设置画笔颜色
    PopupMenu pop = new PopupMenu();
    MenuItem redItem = new MenuItem("Red");
    MenuItem greenItem = new MenuItem("Green");
    MenuItem blueItem = new MenuItem("Blue");
    // 定义一个BufferedImage对象
    BufferedImage image = new BufferedImage(AREA_WIDTH, AREA_HEIGHT, BufferedImage.TYPE_INT_RGB);
    // 获取image对象的Graphics
    Graphics g = image.getGraphics();
    private Frame f = new Frame("复制图片");
    private DrawCanvas drawArea = new DrawCanvas();
    // 用于保存画笔颜色
    private Color foreColor = new Color(255, 0, 0);

    public void init() {
        // 定义右键菜单的事件监听器
        ActionListener menuListener = e -> {
            if (e.getActionCommand().equals("Green")) {
                foreColor = new Color(0, 255, 0);
            }
            if (e.getActionCommand().equals("Red")) {
                foreColor = new Color(255, 0, 0);
            }
            if (e.getActionCommand().equals("Blue")) {
                foreColor = new Color(0, 0, 255);
            }
        };
        // 为三个菜单添加事件监听器
        redItem.addActionListener(menuListener);
        greenItem.addActionListener(menuListener);
        blueItem.addActionListener(menuListener);
        // 将菜单项组合成右键菜单
        pop.add(redItem);
        pop.add(greenItem);
        pop.add(blueItem);
        // 将右键菜单添加到drawArea对象中
        drawArea.add(pop);
        // 将image对象的背景色填充成白色
        g.fillRect(0, 0, AREA_WIDTH, AREA_HEIGHT);
        drawArea.setPreferredSize(new Dimension(AREA_WIDTH, AREA_HEIGHT));
        // 监听鼠标移动动作
        drawArea.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 如果preX和preY大于0
                if (preX > 0 && preY > 0) {
                    // 设置当前颜色
                    g.setColor(foreColor);
                    // 绘制从上一次鼠标拖动事件到本次鼠标拖动事件点的线段
                    g.drawLine(preX, preY, e.getX(), e.getY());
                }
                // 将当前鼠标事件点的X、Y坐标保存起来
                preX = e.getX();
                preY = e.getY();
                // 重绘drawArea对象
                drawArea.repaint();
            }
        });

        // 监听鼠标事件
        drawArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // 弹出右键菜单
                if (e.isPopupTrigger()) {
                    pop.show(drawArea, e.getX(), e.getY());
                }
                // 松开鼠标键时，把上一次鼠标拖动事件的X，Y坐标设为-1
                preX = -1;
                preY = -1;
            }
        });
        f.add(drawArea);
        var p = new Panel();
        var copy = new Button("Copy");
        var paste = new Button("Paste");
        copy.addActionListener(event -> {
            // 将image对象封装成ImageSelection对象
            var contents = new B_ImageSelection(image);
            // 将ImageSelection对象放入剪贴板
            clipboard.setContents(contents, null);
        });

        paste.addActionListener(event -> {
            // 如果剪贴板中包含imageFlavor内容
            if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor)) {
                try {
                    // 取出剪贴板中的imageFlavor内容，并将其添加 到List集合中
                    imageList.add((Image) clipboard.getData(DataFlavor.imageFlavor));
                    drawArea.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        p.add(copy);
        p.add(paste);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new C_CopyImage().init();
    }

    private class DrawCanvas extends Canvas {

        // 重写Canvas的paint()方法，实现绘画
        @Override
        public void paint(Graphics g) {
            // 将image绘制到该组件上
            g.drawImage(image, 0, 0, null);
            // 将List里的所有Image对象都绘制出来
            for (var img : imageList) {
                g.drawImage(img, 0, 0, null);
            }
        }
    }
}
