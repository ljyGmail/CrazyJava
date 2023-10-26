package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class J_TransientTest {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                var oos = new ObjectOutputStream(new FileOutputStream("data/ch15/transient.txt"));
                // 创建一个ObjectInputStream输出流
                var ois = new ObjectInputStream(new FileInputStream("data/ch15/transient.txt"))) {
            var per = new I_Person("孙悟空", 500);
            // 系统将per对象转换成字节序列并输出
            oos.writeObject(per);
            var p = (I_Person) ois.readObject();
            System.out.println(p.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
