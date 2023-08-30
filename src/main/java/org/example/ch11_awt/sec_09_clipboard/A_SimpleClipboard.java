package org.example.ch11_awt.sec_09_clipboard;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

public class A_SimpleClipboard {
    private Frame f = new Frame("简单的剪贴板程序");
    // 获取系统剪贴板
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    // 下面时创建本地剪贴板的代码
    // Clipboard clipboard = new Clipboard("cb");
    // 用于复制文本的文本框
    private TextArea jtaCopyTo = new TextArea(5, 20);
    // 用于黏贴文本的文本框
    private TextArea jtaPaste = new TextArea(5, 20);
    private Button btCopy = new Button("Copy"); // Copy Button
    private Button btPaste = new Button("Paste"); // Paste Button

    public void init() {
        var p = new Panel();
        p.add(btCopy);
        p.add(btPaste);
        btCopy.addActionListener(event -> {
            // 将一个多行文本域里的字符串封装成StringSelection对象
            var contents = new StringSelection(jtaCopyTo.getText());
            // 将StringSelection对象放入剪贴板
            clipboard.setContents(contents, null);
        });

        btPaste.addActionListener(event -> {
            // 如果剪贴板中包含stringFlavor内容
            if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                try {
                    // 取出剪贴板中的stringFlavor内容
                    var content = (String) clipboard.getData(DataFlavor.stringFlavor);
                    jtaPaste.append(content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 创建一个水平排列的Box容器
        var box = new Box(BoxLayout.X_AXIS);
        // 将两个多行文本域放在Box容器中
        box.add(jtaCopyTo);
        box.add(jtaPaste);
        // 将按钮所在的Panel, Box容器添加到Frame窗口中
        f.add(p, BorderLayout.SOUTH);
        f.add(box, BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SimpleClipboard().init();
    }
}
