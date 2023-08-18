package org.example.ch11_awt.sec_03_layout_manager;

import javax.swing.*;
import java.awt.*;

public class I_BoxTest {
    private Frame f = new Frame("测试");
    // 定义水平摆放组件的Box对象
    private Box horizontal = Box.createHorizontalBox();
    // 定义垂直摆放组件的Box对象
    private Box vertical = Box.createVerticalBox();

    public void init() {
        horizontal.add(new Button("Horizontal Button One"));
        horizontal.add(new Button("Horizontal Button Two"));
        vertical.add(new Button("Vertical Button One"));
        vertical.add(new Button("Vertical Button Two"));
        f.add(horizontal, BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new I_BoxTest().init();
    }
}
