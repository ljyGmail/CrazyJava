package org.example.ch05_oop1.sec_01_class_obj;

public class B_PersonTest {
    public static void main(String[] args) {
        // 使用Person类定义一个Person类型的变量
//        A_Person p;
        // 通过new关键字调用Person类的构造器，返回一个Person实例
        // 将该Person实例赋给p变量
//        p = new A_Person();

        // 定义p变量的同时并为p变量赋值
//        A_Person p = new A_Person();

        // 使用var定义引用类型的变量
        var p = new A_Person();

        // 访问p的name实例变量，直接为该变量赋值
        p.name = "李刚";
        // 调用p的say()方法，声明say()方法时定义了一个形参
        // 调用该方法必须为形参指定一个值
        p.say("Java语言很简单，学习很容易!");
        // 直接输出p的name实例变量，将输出 李刚
        System.out.println(p.name);

        var p2 = p;
    }
}
