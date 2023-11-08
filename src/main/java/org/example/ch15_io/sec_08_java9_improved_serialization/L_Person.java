package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.ObjectStreamException;
import java.util.ArrayList;

public class L_Person implements java.io.Serializable {
    private String name;
    private int age;

    // 注意此处没有提供无参数的构造器
    public L_Person(String name, int age) {
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

    // 重写writeReplace方法，程序在序列化该对象之前，先调用该方法
    private Object writeReplace() throws ObjectStreamException {
        ArrayList<Object> list = new ArrayList<>();
        list.add(name);
        list.add(age);
        return list;
    }
}
