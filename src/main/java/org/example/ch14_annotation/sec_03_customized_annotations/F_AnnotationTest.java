package org.example.ch14_annotation.sec_03_customized_annotations;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class F_AnnotationTest {
    private JFrame mainWin = new JFrame("使用注解绑定事件监听器");
    // 使用@ActionListenerFor注解为ok按钮绑定事件监听器
    @E_ActionListenerFor(listener = OkListener.class)
    private JButton ok = new JButton("确定");
    // 使用@ActionListener注解为cancel按钮绑定事件监听器
    @E_ActionListenerFor(listener = CancelListener.class)
    private JButton cancel = new JButton("取消");

    public void init() {
        // 初始化界面的方法
        var jp = new JPanel();
        jp.add(ok);
        jp.add(cancel);
        mainWin.add(jp);
        G_ActionListenerInstaller.processAnnotations(this);
        mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWin.pack();
        mainWin.setVisible(true);
    }

    public static void main(String[] args) {
        new F_AnnotationTest().init();
    }
}

// 定义ok按钮的事件监听器实现类
class OkListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "单击了取消按钮");
    }
}

// 定义cancel按钮的事件监听器实现类
class CancelListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "单击了取消按钮");
    }
}