package org.example.ch18_reflection.sec_01_class_loading_link_initialization;

public class C_ATest2 {
    public static void main(String[] args) {
        // 创建A类的实例
        var b = new A_A();
        // 输出b实例的类变量a的值
        System.out.println(b.a);
    }
}
