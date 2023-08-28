package org.example.ch11_awt.sec_06_awt_menu;

import java.awt.*;
import java.awt.event.*;

public class B_PopupMenuTest {
    private TextArea ta = new TextArea(4, 30);
    private Frame f = new Frame("测试");
    PopupMenu pop = new PopupMenu();
    CheckboxMenuItem autoWrap = new CheckboxMenuItem("Auto Wrap");
    MenuItem copyItem = new MenuItem("Copy");
    MenuItem pasteItem = new MenuItem("Paste");
    Menu format = new Menu("Format");
    // 创建commentItem菜单项，指定使用"Ctrl+Shift+/"快捷键
    MenuItem commentItem = new MenuItem("Comment", new MenuShortcut(KeyEvent.VK_SLASH, true));
    MenuItem cancelItem = new MenuItem("Cancel Comment");

    public void init() {
        // 以Lambda表达式创建菜单事件监听器
        ActionListener menuListener = e -> {
            var cmd = e.getActionCommand();
            if (cmd.equals("Exit")) {
                System.exit(0);
            }
        };
        // 为commentItem菜单项添加事件监听器
        commentItem.addActionListener(menuListener);
        // 为pop菜单添加菜单项
        pop.add(autoWrap);
        // 使用addSeparator()方法来添加菜单分隔线
        pop.addSeparator();
        pop.add(copyItem);
        pop.add(pasteItem);
        // 为format菜单添加菜单项
        format.add(commentItem);
        format.add(cancelItem);
        // 使用添加new MenuItem("-")的方式添加菜单分隔线
        pop.add(new MenuItem("-"));
        // 将format菜单组合到pop菜单中，从而形成二级菜单
        pop.add(format);
        final var p = new Panel();
        p.setPreferredSize(new Dimension(300, 160));
        // 向p窗口添加PopupMenu对象
        p.add(pop);
        // 添加鼠标事件监听器
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // 如果释放的是鼠标邮件
                if (e.isPopupTrigger()) {
                    pop.show(p, e.getX(), e.getY());
                }
            }
        });
        f.add(p);
        f.add(ta, BorderLayout.NORTH);
        // 以匿名内部类的形式来创建事件监听器对象
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new B_PopupMenuTest().init();
    }
}
