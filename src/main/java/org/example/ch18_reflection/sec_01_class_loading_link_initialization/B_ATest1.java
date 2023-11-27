package org.example.ch18_reflection.sec_01_class_loading_link_initialization;

public class B_ATest1 {
    public static void main(String[] args) {
        // 创建A类的实例
        var a = new A_A();
        // 让a实例的类变量a的值自加
        a.a++;
        System.out.println(a.a);
    }
}
