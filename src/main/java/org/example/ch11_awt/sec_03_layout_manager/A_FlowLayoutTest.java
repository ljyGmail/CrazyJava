package org.example.ch11_awt.sec_03_layout_manager;

import java.awt.*;

public class A_FlowLayoutTest {
    public static void main(String[] args) {
        var f = new Frame("测试窗口");
        // 设置Frame容器使用FlowLayout布局管理器
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 5));
        // 向窗口中添加10个按钮
        for (var i = 0; i < 10; i++) {
            f.add(new Button("Button " + i));
        }
        // 设置窗口为最佳大小
        f.pack();
        // 将窗口显式出来(Frame对象默认处于隐藏状态)
        f.setVisible(true);
    }
}
