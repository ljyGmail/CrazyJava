package org.example.ch15_io.sec_06_jvm_read_write_process;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class B_WriteToProcess {
    public static void main(String[] args) throws IOException {
        // 运行java ReadStandard命令，返回运行该命令的子进程
        Process p = Runtime.getRuntime().exec("java -classpath C:/Users/liang/Desktop/Workspace/JavaWorkspace/CrazyJava/target/classes org.example.ch15_io.sec_06_jvm_read_write_process.ReadStandard");
        try (
                // 以p进程的输出流创建PrintStream对象
                // 这个输出流对本程序是输出流，对p进程则是输入流
                var ps = new PrintStream(p.getOutputStream())) {
            // 向ReadStandard程序写入内容，这些内容将被ReadStandard读取
            ps.println("普通字符串");
            ps.println(new B_WriteToProcess());
            System.out.println("Done!");
        }
    }
}

// 定义一个ReadStandard类，该类可以接受标准输入
// 并将标准输入写入out.txt文件
class ReadStandard {
    public static void main(String[] args) {
        try (
                // 使用System.in创建Scanner对象，用于获取标准输入
                var sc = new Scanner(System.in);
                var ps = new PrintStream(new FileOutputStream("data/ch15/out_6.txt"))) {
            // 增加下面一行只把回车作为分隔符
            sc.useDelimiter("\n");
            // 判断是否还有下一个输入项
            while (sc.hasNext()) {
                // 输出输入项
                System.out.println("xxx");
                ps.println("键盘输入的内容是: " + sc.next());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
