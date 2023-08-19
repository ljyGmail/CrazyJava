package org.example.ch11_awt.sec_05_event_handling;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class D_WindowAdapterTest {
    private Frame f=new Frame("测试");
    private TextArea ta=new TextArea(6,40);
    public void init(){
        f.addWindowListener(new MyListener());
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    private class MyListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("用户关闭窗口!\n");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new D_WindowAdapterTest().init();
    }
}
