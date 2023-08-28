package org.example.ch11_awt.sec_07_drawing_in_awt;

import java.awt.*;
import java.util.Random;

public class A_SimpleDraw {
    private final String RECT_SHAPE = "rect";
    private final String OVAL_SHAPE = "oval";
    private Frame f = new Frame("简单绘图");
    private Button rect = new Button("Draw Rect");
    private Button oval = new Button("Draw Circle");
    private MyCanvas drawArea = new MyCanvas();
    // 用于保存需要绘制什么图形的变量
    private String shape = "";

    public void init() {
        var p = new Panel();
        rect.addActionListener(e -> {
            // 设置shape变量为RECT_SHAPE
            shape = RECT_SHAPE;
            // 重画MyCanvas对象，即调用它的repaint()方法
            drawArea.repaint();
        });
        oval.addActionListener(e -> {
            // 设置shape变量为OVAL_SHAPE
            shape = OVAL_SHAPE;
            // 重画MyCanvas对象，即调用它的repaint()方法
            drawArea.repaint();
        });
        p.add(rect);
        p.add(oval);
        drawArea.setPreferredSize(new Dimension(250, 180));
        f.add(drawArea);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SimpleDraw().init();
    }

    class MyCanvas extends Canvas {
        // 重写Canvas的paint()方法，实现绘画
        public void paint(Graphics g) {
            var rand = new Random();
            if (shape.equals(RECT_SHAPE)) {
                // 设置画笔颜色
                g.setColor(new Color(220, 100, 80));
                // 随机地绘制一个矩形框
                g.drawRect(rand.nextInt(200), rand.nextInt(120), 40, 60);
            }

            if (shape.equals(OVAL_SHAPE)) {
                // 设置画笔颜色
                g.setColor(new Color(80, 100, 200));
                // 随机地填充一个实心原型
                g.fillOval(rand.nextInt(200), rand.nextInt(120), 50, 40);
            }
        }
    }
}

