package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class C_ReadObject {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectInputStream输入流
                var ois = new ObjectInputStream(new FileInputStream("data/ch15/object.txt"))) {
            // 从输入流读取一个Java对象，并将其强制类型转换为Person类
            var p = (A_Person) ois.readObject();
            System.out.println("名字为: " + p.getName() + "\n年龄为: " + p.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
