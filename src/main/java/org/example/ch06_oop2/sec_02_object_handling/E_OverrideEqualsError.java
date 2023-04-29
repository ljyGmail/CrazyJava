package org.example.ch06_oop2.sec_02_object_handling;

// 定义一个Human类
class Human {
    // 重写equals()方法，提供自定义的相等标准
    public boolean equals(Object obj) {
        // 不加判断，总是返回true, 即Human对象与任何对象相等
        return true;
    }
}

// 定义一个Dog空类
class Dog {
}

public class E_OverrideEqualsError {
    public static void main(String[] args) {
        var h = new Human();
        System.out.println("Human对象是否equals Dog对象? " + h.equals(new Dog()));
        System.out.println("Human对象是否equals String对象? " + h.equals(new String("Hello")));
    }
}
