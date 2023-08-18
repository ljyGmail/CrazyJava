package org.example.ch11_awt.sec_03_layout_manager;

import java.awt.*;

import static java.awt.BorderLayout.*;

public class B_BorderLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        // 设置Frame容器使用BorderLayout布局管理器
        f.setLayout(new BorderLayout(30, 5));
        f.add(new Button("S"), SOUTH);
        f.add(new Button("N"), NORTH);
        // 默认添加到中间区域中
        f.add(new Button("C"));
        f.add(new Button("E"), EAST);
        f.add(new Button("W"), WEST);
        // 设置窗口为最佳大小
        f.pack();
        // 将窗口显示出来(Frame对象默认处于隐藏状态)
        f.setVisible(true);
    }
}
