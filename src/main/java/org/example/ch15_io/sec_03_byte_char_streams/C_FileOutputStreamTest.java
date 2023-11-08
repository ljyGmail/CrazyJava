package org.example.ch15_io.sec_03_byte_char_streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C_FileOutputStreamTest {
    public static void main(String[] args) {
        try (
                // 创建字节输入流
                var fis = new FileInputStream("src/main/java/org/example/ch15_io/sec_03_byte_char_streams/C_FileOutputStreamTest.java");
                // 创建字节 输出流
                var fos = new FileOutputStream("data/ch15/newFile.txt")
        ) {
            var bbuf = new byte[22];
            var hasRead = 0;
            // 循环从输入流中取出数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                // 每次取一次，即写入文件输出流，读了多少，就写多少
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
