package org.example.ch18_reflection.sec_02_class_loader;

public class C_Hello {
    public static void main(String[] args) {
        for (var arg : args) {
            System.out.println("运行Hello的参数: " + arg);
        }
    }
}
