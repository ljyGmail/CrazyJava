package org.example.ch11_awt.sec_05_event_handling;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class A_EventQs {
    private Frame f = new Frame("测试事件");
    private Button ok = new Button("OK");
    private TextField tf = new TextField(30);

    public void init() {
        // 注册事件监听器
        ok.addActionListener(new OkListener());
        f.add(tf);
        f.add(ok, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    // 定义事件监听器类
    private class OkListener implements ActionListener {
        // 下面定义的方法就是事件处理器，用于响应特定的事件
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("用户单击了ok按钮");
            tf.setText("Hello World");
        }
    }

    public static void main(String[] args) {
        new A_EventQs().init();
    }
}
