package org.example.ch11_awt.sec_03_layout_manager;

import java.awt.*;
import java.awt.event.ActionListener;

public class F_CardLayoutTest {
    Frame f = new Frame("测试窗口");
    String[] names = {"first", "second", "third", "fourth", "fifth"};
    Panel pl = new Panel();

    public void init() {
        final var c = new CardLayout();
        pl.setLayout(c);
        for (var i = 0; i < names.length; i++) {
            pl.add(names[i], new Button(names[i]));
        }
        var p = new Panel();
        ActionListener listener = e -> {
            switch (e.getActionCommand()) {
                case "previous":
                    c.previous(pl);
                    break;
                case "next":
                    c.next(pl);
                    break;
                case "first":
                    c.first(pl);
                    break;
                case "last":
                    c.last(pl);
                    break;
                case "third":
                    c.show(pl, "third");
                    break;
            }
        };
        // 控制显示上一张的按钮
        var previous = new Button("previous");
        previous.addActionListener(listener);
        // 控制显示下一张的按钮
        var next = new Button("next");
        next.addActionListener(listener);
        // 控制显示第一张的按钮
        var first = new Button("first");
        first.addActionListener(listener);
        // 控制显示最后一张的按钮
        var last = new Button("last");
        last.addActionListener(listener);
        // 控制根据Card名显示的按钮
        var third = new Button("third");
        third.addActionListener(listener);
        p.add(previous);
        p.add(next);
        p.add(first);
        p.add(last);
        p.add(third);
        f.add(pl);
        f.add(p, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new F_CardLayoutTest().init();
    }
}
