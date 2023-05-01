package org.example.ch06_oop2.sec_04_final;

public class B_FinalErrorTest {
    // 定义一个final修饰的实例变量
    // 系统不会对final成员变量进行默认初始化
    final int age;

    {
        // age没有初始化，所以此处代码将引起错误
        // System.out.println(age);
        printAge(); // 这行代码是合法的，程序输出0
        age = 6;
        System.out.println(age);
    }

    public void printAge(){
        System.out.println(age);
    }

    public static void main(String[] args) {
        new B_FinalErrorTest();
    }
}
