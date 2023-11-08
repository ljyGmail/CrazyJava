package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class E_WriteTeacher {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectOutputStream输出流
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/ch15/8_3_teacher.txt"))) {
            var per = new A_Person("孙悟空", 500);
            var t1 = new D_Teacher("唐僧", per);
            var t2 = new D_Teacher("菩提祖师", per);
            // 依次将4个对象写入输出流
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(per);
            oos.writeObject(t2);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
