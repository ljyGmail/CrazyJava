package org.example.ch18_reflection.sec_01_class_loading_link_initialization;

public class D_ClassInitializationTest {
    static {
        // 使用静态初始化块为变量b指定初始值
        b = 6;
        System.out.println("----------");
    }

    static int a = 5;
    static int b = 9;
    static int c;

    public static void main(String[] args) {
        System.out.println(D_ClassInitializationTest.b);
    }
}
