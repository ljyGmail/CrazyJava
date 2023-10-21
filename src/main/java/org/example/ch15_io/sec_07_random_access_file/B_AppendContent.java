package org.example.ch15_io.sec_07_random_access_file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class B_AppendContent {
    public static void main(String[] args) {
        try (
                // 以读、写方式打开一个RandomAccessFile对象
                var raf = new RandomAccessFile("data/ch15/out_7_1.txt", "rw")) {
            // 将记录指针移动到out.txt文件的最后
            raf.seek(raf.length());
            raf.write("追加的内容!\r\n".getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
