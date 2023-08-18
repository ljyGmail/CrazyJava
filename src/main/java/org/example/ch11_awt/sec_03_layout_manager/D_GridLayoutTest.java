package org.example.ch11_awt.sec_03_layout_manager;

import java.awt.*;

import static java.awt.BorderLayout.*;

public class D_GridLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("计算器");
        var p1 = new Panel();
        p1.add(new TextField(30));
        f.add(p1, NORTH);
        var p2 = new Panel();
        // 设置Panel使用GridLayout布局杠两千
        p2.setLayout(new GridLayout(3, 5, 4, 4));
        String[] name = {"0", "1", "2", "3",
                "4", "5", "6", "7", "8", "9",
                "+", "-", "*", "/", "."};
        // 向Panel中一次添加15个按钮
        for (var i = 0; i < name.length; i++) {
            p2.add(new Button(name[i]));
        }
        // 默认将Panel对象添加到Frame窗口的中间
        f.add(p2);
        // 设置窗口为最佳大小
        f.pack();
        // 将窗口显示出来(Frame大小默认处于隐藏状态)
        f.setVisible(true);
    }
}
