package org.example.ch11_awt.sec_03_layout_manager;

import javax.swing.*;
import java.awt.*;

public class H_BoxLayoutTest {
    private Frame f = new Frame("测试");

    public void init() {
        f.setLayout(new BoxLayout(f, BoxLayout.Y_AXIS));
        // 下面按钮将会垂直排列
        f.add(new Button("First Button"));
        f.add(new Button("Second Button"));
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new H_BoxLayoutTest().init();
    }
}
