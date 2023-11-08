package org.example.ch15_io.sec_07_random_access_file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class A_RandomAccessFileTest {
    public static void main(String[] args) {
        try (
                var raf = new RandomAccessFile("src/main/java/org/example/ch15_io/sec_07_random_access_file/A_RandomAccessFileTest.java", "r")) {
            // 获取RandomAccessFile对象文件指针的位置，初始位置为0
            System.out.println("RandomAccessFile的文件指针的初始位置: " + raf.getFilePointer());
            // 移动raf的文件记录指针的位置
            raf.seek(300);
            var bbuf = new byte[1024];
            // 用于保存实际读取的字节数
            var hasRead = 0;
            // 使用循环来重复"取水"过程
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 取出"竹筒"中的水滴(字节)，将字节数组转换成字符串输入
                System.out.println(new String(bbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
