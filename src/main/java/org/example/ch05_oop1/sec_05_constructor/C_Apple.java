package org.example.ch05_oop1.sec_05_constructor;

public class C_Apple {
    public String name;
    public String color;
    public double weight;

    public C_Apple() {
    }
    // 两个参数的构造器

    public C_Apple(String name, String color) {
        this.name = name;
        this.color = color;
    }
    // 三个参数的构造器

    public C_Apple(String name, String color, double weight) {
        // 通过this调用另一个重载的构造器的初始化代码
        this(name, color);
        // 下面this引用该构造器正在初始化的对象
        this.weight = weight;
    }
}
