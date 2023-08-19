package org.example.ch11_awt.sec_05_event_handling;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class H_AnonymousEventHandler {
    private Frame f=new Frame("测试");
    private TextArea ta=new TextArea(6, 40);

    public void init(){
        // 以匿名内部类的形式来创建事件监听器对象
        f.addWindowListener(new WindowAdapter() {
            // 实现事件处理方法
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("用户试图关闭窗口!\n");
                System.exit(0);
            }
        });
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new H_AnonymousEventHandler().init();
    }
}
