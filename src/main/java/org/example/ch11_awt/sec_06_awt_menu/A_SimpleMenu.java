package org.example.ch11_awt.sec_06_awt_menu;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class A_SimpleMenu {
    private Frame f = new Frame("测试");
    private MenuBar mb = new MenuBar();
    Menu file = new Menu("File");
    Menu edit = new Menu("Edit");
    MenuItem newItem = new MenuItem("New");
    MenuItem saveItem = new MenuItem("Save");
    // 创建exitItem菜单项，指定使用"Ctrl+X"快捷键
    MenuItem exitItem = new MenuItem("Exit", new MenuShortcut(KeyEvent.VK_X));
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("Auto Wrap");
    MenuItem copyItem = new MenuItem("Copy");
    MenuItem pasteItem = new MenuItem("Paste");
    Menu format = new Menu("Format");
    // 创建commentItem菜单项，指定使用"Ctrl+Shift+/"快捷键
    MenuItem commentItem = new MenuItem("Comment", new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelItem = new MenuItem("Cancel Comment");
    private TextArea ta = new TextArea(6, 40);

    public void init() {
        // 以Lambda表达式创建菜单事件监听器
        ActionListener menuListener = e -> {
            var cmd = e.getActionCommand();
            ta.append("单击 " + cmd + " 菜单\n");
            if (cmd.equals("Exit")) {
                System.exit(0);
            }
        };
        // 为commentItem菜单项添加事件监听器
        commentItem.addActionListener(menuListener);
        exitItem.addActionListener(menuListener);
        // 为file菜单添加
        file.add(newItem);
        file.add(saveItem);
        file.add(exitItem);
        // 为edit菜单添加菜单项
        edit.add(autoWrap);
        // 使用addSeparator()方法来添加菜单分隔线
        edit.addSeparator();
        edit.add(copyItem);
        edit.add(pasteItem);
        // 为format菜单添加菜单项
        format.add(commentItem);
        format.add(cancelItem);
        // 使用添加new MenuItem("-")的方式添加菜单分隔线
        edit.add(new MenuItem("-"));
        // 将format菜单组合到edit菜单中，从而形成二级菜单
        edit.add(format);
        // 将file，edit菜单添加到mb菜单条中
        mb.add(file);
        mb.add(edit);
        // 为f窗口设置菜单条
        f.setMenuBar(mb);
        // 以匿名内部类的形式来创建事件监听器对象
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.add(ta);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new A_SimpleMenu().init();
    }
}
