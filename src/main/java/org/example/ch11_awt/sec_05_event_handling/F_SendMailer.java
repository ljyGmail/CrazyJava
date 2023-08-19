package org.example.ch11_awt.sec_05_event_handling;

import java.awt.*;

public class F_SendMailer {
    private Frame f = new Frame("测试");
    private TextField tf = new TextField(40);
    private Button send = new Button("Send");

    public void init() {
        // 使用MailerListener对象作为事件监听器
        send.addActionListener(new E_MailerListener(tf));
        f.add(tf);
        f.add(send, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new F_SendMailer().init();
    }
}
