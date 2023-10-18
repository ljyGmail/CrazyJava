package org.example.ch15_io.sec_04_io_system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class A_PrintStreamTest {
    public static void main(String[] args) {
        try (
                var fos = new FileOutputStream("data/ch15/test_4_1.txt");
                var ps = new PrintStream(fos)) {
            // 使用PrintStream执行输出
            ps.println("普通字符串");
            // 直接使用PrintStream输出对象
            ps.println(new A_PrintStreamTest());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
