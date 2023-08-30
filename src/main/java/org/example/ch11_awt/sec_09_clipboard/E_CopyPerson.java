package org.example.ch11_awt.sec_09_clipboard;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

class Person {
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person[name: " + name + ", age: " + age + "]";
    }
}

public class E_CopyPerson {
    Frame f = new Frame("复制对象");
    Button copy = new Button("Copy");
    Button paste = new Button("Paste");
    TextField name = new TextField(15);
    TextField age = new TextField(15);
    TextArea ta = new TextArea(3, 30);
    // 创建本地剪贴板
    Clipboard clipboard = new Clipboard("cp");

    public void init() {
        var p = new Panel();
        p.add(new Label("Name"));
        p.add(name);
        p.add(new Label("Age"));
        p.add(age);
        f.add(p, BorderLayout.NORTH);
        f.add(ta);
        var bp = new Panel();
        // 为"复制"按钮添加事件监听器
        copy.addActionListener(e -> copyPerson());
        // 为"黏贴"按钮添加事件监听器
        paste.addActionListener(e -> {
            try {
                readPerson();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        });
        bp.add(copy);
        bp.add(paste);
        f.add(bp, BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }

    public void copyPerson() {
        // 以name, age文本框的内容创建Person对象
        var p = new Person(name.getText(), Integer.parseInt(age.getText()));
        // 将Person对象封装成LocalObjectSelection对象
        var ls = new D_LocalObjectSelection(p);
        // 将LocalObjectSelection对象放入本地剪贴板中
        clipboard.setContents(ls, null);
    }

    public void readPerson() throws Exception {
        // 创建保存Person对象引用的DataFlavor对象
        var personFlavor = new DataFlavor("application/x-java-jvm-local-objectref;class=org.example.ch11_awt.sec_09_clipboard.Person");
        // 取出本地剪贴板中的内容
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            var p = (Person) clipboard.getData(personFlavor);
            ta.setText(p.toString());
        }
    }

    public static void main(String[] args) {
        new E_CopyPerson().init();
    }
}

