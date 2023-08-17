package org.example.ch11_awt.sec_02_awt_container;

import java.awt.*;

public class A_FrameTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        // 设置窗口的大小，位置
        f.setBounds(30, 30, 250, 200);
        // 将窗口显式出来(Frame对象默认处于隐藏状态)
        f.setVisible(true);
    }
}
