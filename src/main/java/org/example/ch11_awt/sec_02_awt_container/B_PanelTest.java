package org.example.ch11_awt.sec_02_awt_container;

import java.awt.*;
import java.io.UnsupportedEncodingException;

public class B_PanelTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        var f = new Frame("测试窗口");
        // 创建一个Panel容器
        var p = new Panel();
        // 向Panel容器中添加两个组件
        p.add(new TextField(20));
        p.add(new Button("Click Me!"));
        // 将Panel日期添加到Frame窗口中
        f.add(p);
        // 设置窗口的大小、位置
        f.setBounds(30, 30, 250, 120);
        // 将窗口显式出来(Frame对象默认处于隐藏状态)
        f.setVisible(true);
    }
}
