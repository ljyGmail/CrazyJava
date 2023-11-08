package org.example.ch15_io.sec_08_java9_improved_serialization;

public class A_Person implements java.io.Serializable {
    private String name;
    private int age;

    // 注意此处没有提供无参数的构造器
    public A_Person(String name, int age) {
        System.out.println("有参数的构造器");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
