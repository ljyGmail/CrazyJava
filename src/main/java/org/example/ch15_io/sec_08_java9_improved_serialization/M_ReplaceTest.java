package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class M_ReplaceTest {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                var oos = new ObjectOutputStream(new FileOutputStream("data/ch15/replace.txt"));
                // 创建一个ObjectInputStream输入流
                var ois = new ObjectInputStream(new FileInputStream("data/ch15/replace.txt"))) {
            var per = new L_Person("孙悟空", 500);
            // 系统将per对象转换成字节序列并输出
            oos.writeObject(per);
            // 反序列化读取得到的是ArrayList
            var list = (ArrayList) ois.readObject();
            System.out.println(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
