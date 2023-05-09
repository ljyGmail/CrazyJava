package org.example.ch07_basic_api.sec_01_user_interactivity;

import java.io.File;
import java.util.Scanner;

public class D_ScannerFileTest {
    public static void main(String[] args) throws Exception {
        // 将一个File对象作为Scanner的构造器参数，Scanner读取文件内容
        var sc = new Scanner(new File("src/main/java/org/example/ch07_basic_api/sec_01_user_interactivity/D_ScannerFileTest.java"));
        System.out.println("ScannerFileTest.java文件内容如下:");
        // 判断是否还有下一行
        while (sc.hasNextLine()) {
            // 输出文件中的下一行
            System.out.println(sc.nextLine());
        }
    }
}
