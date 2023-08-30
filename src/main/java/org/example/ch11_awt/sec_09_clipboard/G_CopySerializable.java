package org.example.ch11_awt.sec_09_clipboard;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.Serializable;

class Dog implements Serializable {
    private String name;
    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog[name: " + name + ", age:" + age + "]";
    }
}

public class G_CopySerializable {
    Frame f = new Frame("复制对象");
    Button copy = new Button("Copy");
    Button paste = new Button("Paste");
    TextField name = new TextField(15);
    TextField age = new TextField(15);
    TextArea ta = new TextArea(3, 30);
    // 创建系统剪贴板
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public void init() {
        var p = new Panel();
        p.add(new Label("Name"));
        p.add(name);
        p.add(new Label("Age"));
        p.add(age);
        f.add(p, BorderLayout.NORTH);
        f.add(ta);
        var bp = new Panel();
        copy.addActionListener(e -> copyDog());
        paste.addActionListener(e -> {
            try {
                readDog();
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

    public void copyDog() {
        var d = new Dog(name.getText(), Integer.parseInt(age.getText()));
        // 把dog实例封装成SerialSelection对象
        var ls = new F_SerialSelection(d);
        // 把SerialSelection对象放入系统剪贴板中
        clipboard.setContents(ls, null);
    }

    public void readDog() throws Exception {
        var dogFlavor = new DataFlavor(DataFlavor.javaSerializedObjectMimeType + ";class=org.example.ch11_awt.sec_09_clipboard.Dog");
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            // 从系统剪贴板中读取数据
            var d = (Dog) clipboard.getData(dogFlavor);
            ta.setText(d.toString());
        }
    }

    public static void main(String[] args) {
        new G_CopySerializable().init();
    }
}
