package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class N_Person implements java.io.Externalizable {

    private String name;
    private int age;

    // 注意必须提供无参数的构造器，否则反序列化时会失败
    public N_Person() {
    }

    public N_Person(String name, int age) {
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 将name实例变量值反转后写入二进制流
        out.writeObject(new StringBuffer(name).reverse());
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // 将读取的字符串反转后赋给name实例变量
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        this.age = in.readInt();
    }
}
