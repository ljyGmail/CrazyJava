package org.example.ch05_oop1.sec_04_encapsulation.lee;

// 使用import导入lee.sub.Apple类

import org.example.ch05_oop1.sec_04_encapsulation.lee.sub.Apple;

public class HelloTest {
    public static void main(String[] args) {
        var h = new Hello();
        // 使用类全名的写法
        // var a = new org.example.ch05_oop1.sec_04_encapsulation.lee.sub.Apple();
        // 如果使用import语句来导入Apple类，就可以不再使用类全名了
        var a = new Apple();
    }
}
