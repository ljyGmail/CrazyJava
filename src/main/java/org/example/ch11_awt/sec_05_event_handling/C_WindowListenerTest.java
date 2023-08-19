package org.example.ch11_awt.sec_05_event_handling;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class C_WindowListenerTest {
    private Frame f=new Frame("测试");
    private  TextArea ta=new TextArea(6,40);
    public void init(){
        // 为窗口添加窗口事件监听器
        f.addWindowListener(new MyListener());
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    private class MyListener implements WindowListener {
        @Override
        public void windowOpened(WindowEvent e) {
            ta.append("窗口初次被打开!\n");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            ta.append("用户关闭窗口!\n");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            ta.append("窗口被成功关闭!\n");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            ta.append("窗口被最小化!\n");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            ta.append("窗口被恢复!\n");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            ta.append("窗口被激活!\n");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            ta.append("窗口失去焦点!\n");
        }
    }

    public static void main(String[] args) {
        new C_WindowListenerTest().init();
    }
}
