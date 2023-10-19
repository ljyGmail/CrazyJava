package org.example.ch15_io.sec_05_io_redirection;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class A_RedirectOut {
    public static void main(String[] args) {
        try (
                // 一次性创建PrintStream输出流
                var ps = new PrintStream(new FileOutputStream("data/ch15/out.txt"))) {
            // 将标准输出重定向到ps输出流
            System.setOut(ps);
            // 向标准输出输出一个字符串
            System.out.println("普通字符串");
            // 向标准输出输出一个对象
            System.out.println(new A_RedirectOut());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
