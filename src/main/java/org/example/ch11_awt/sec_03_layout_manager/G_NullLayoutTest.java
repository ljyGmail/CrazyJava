package org.example.ch11_awt.sec_03_layout_manager;

import java.awt.*;

public class G_NullLayoutTest {
    Frame f = new Frame("测试窗口");
    Button b1 = new Button("First Button");
    Button b2 = new Button("Second Button");

    public void init() {
        // 设置使用null布局管理器
        f.setLayout(null);
        // 下面强制设置每个按钮的大小、位置
        b1.setBounds(20, 30, 90, 28);
        f.add(b1);
        b2.setBounds(50, 45, 120, 35);
        f.add(b2);
        f.setBounds(50, 50, 200, 100);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new G_NullLayoutTest().init();
    }
}
