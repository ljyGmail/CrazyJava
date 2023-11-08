package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class F_ReadTeacher {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectInputStream输入流
                var ois = new ObjectInputStream(new FileInputStream("data/ch15/8_3_teacher.txt"))) {
            // 依次读取ObjectInputStream输入流中的4个对象
            var t1 = (D_Teacher) ois.readObject();
            var t2 = (D_Teacher) ois.readObject();
            var p = (A_Person) ois.readObject();
            var t3 = (D_Teacher) ois.readObject();
            // 输出true
            System.out.println("t1的student引用和p是否相同: " + (t1.getStudent() == p));
            // 输出true
            System.out.println("t2的student引用和p是否相同: " + (t2.getStudent() == p));
            // 输出true
            System.out.println("t2和t3是否是同一个对象: " + (t2 == t3));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
