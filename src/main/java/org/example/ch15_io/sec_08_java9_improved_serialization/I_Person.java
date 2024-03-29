package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.Serializable;

public class I_Person implements Serializable {
    private String name;
    private transient int age;

    // 注意此处没有提供无参数的构造器
    public I_Person(String name, int age) {
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
