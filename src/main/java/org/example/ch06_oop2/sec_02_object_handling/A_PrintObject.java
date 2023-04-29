package org.example.ch06_oop2.sec_02_object_handling;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

}

public class A_PrintObject {
    public static void main(String[] args) {
        // 创建一个Person对象，将之赋给p变量
        var p = new Person("孙悟空");
        // 打印p所引用的Person对象
        System.out.println(p);
    }
}
