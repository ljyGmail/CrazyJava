package org.example.ch15_io.sec_06_jvm_read_write_process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_ReadFromProcess {
    public static void main(String[] args) throws IOException {
        // 运行javac命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("javac");
        try (
                // 以p进程的错误流创建BufferedReader对象
                // 这个错误流对本程序是输入流，对p进程则是输出流
                var br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String buff = null;
            // 采取循环方式来读取p进程的错误输入
            while ((buff = br.readLine()) != null) {
                System.out.println(buff);
            }
        }
    }
}
