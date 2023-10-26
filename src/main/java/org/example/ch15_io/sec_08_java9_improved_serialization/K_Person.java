package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.IOException;

public class K_Person implements java.io.Serializable {
    private String name;
    private int age;

    // 注意此处没有提供无参数的构造器
    public K_Person(String name, int age) {
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

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        // 将name实例变量值反转后写入二进制流
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        // 将读取的字符串反转后赋给name实例变量
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
}
