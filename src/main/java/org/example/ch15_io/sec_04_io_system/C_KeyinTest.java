package org.example.ch15_io.sec_04_io_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_KeyinTest {
    public static void main(String[] args) {
        try (
                // 将System.in对象转换成Reader对象
                var reader = new InputStreamReader(System.in);
                // 将普通的Reader包装成BufferedReader
                var br = new BufferedReader(reader)) {
            String line = null;
            // 采用循环方式来逐行地读取
            while ((line = br.readLine()) != null) {
                // 如果读取的字符串为"exit"，则程序退出
                if (line.equals("exit")) {
                    System.exit(1);
                }
                // 打印读取的内容
                System.out.println("输入内容为: " + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
