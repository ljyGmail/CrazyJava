package org.example.ch15_io.sec_05_io_redirection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class B_RedirectIn {
    public static void main(String[] args) {
        try (
                var fis = new FileInputStream("src/main/java/org/example/ch15_io/sec_05_io_redirection/B_RedirectIn.java")) {
            // 将标准输入重定向到fis输入流
            System.setIn(fis);
            // 使用System.in创建Scanner对象，用于获取标准输入
            var sc = new Scanner(System.in);
            // 增加下面一行只把回车作为分隔符
            sc.useDelimiter("\n");
            // 判断是否还有下一个输入项
            while (sc.hasNext()) {
                // 输出输入项
                System.out.println("键盘输入的内容是: " + sc.next());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
