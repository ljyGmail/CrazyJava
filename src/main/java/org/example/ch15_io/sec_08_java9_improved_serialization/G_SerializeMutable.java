package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class G_SerializeMutable {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                var oos = new ObjectOutputStream(new FileOutputStream("data/ch15/8_3_mutable.txt"));
                // 创建一个ObjectInputStream输入流
                var ois = new ObjectInputStream(new FileInputStream("data/ch15/8_3_mutable.txt"))) {
            var per = new A_Person("孙悟空", 500);
            // 系统将per对象转换成字节序列并输出
            oos.writeObject(per);
            // 改变per对象的name实例变量的值
            per.setName("猪八戒");
            // 系统只是输出序列化编号，所以改变后的name不会序列化
            oos.writeObject(per);
            var p1 = (A_Person) ois.readObject();
            var p2 = (A_Person) ois.readObject();
            // 下面输出true，即反序列化后p1等于p2
            System.out.println(p1 == p2);
            // 下面依然看到输出"孙悟空"，即改变后的实例变量没有被序列化
            System.out.println(p2.getName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
