package org.example.ch15_io.sec_10_nio_2;

import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class B_FilesTest {
    public static void main(String[] args) throws Exception {
        // 复制文件
        Files.copy(Paths.get("src/main/java/org/example/ch15_io/sec_10_nio_2/B_FilesTest.java"), new FileOutputStream("data/ch15/files_copy.txt"));
        // 判断FilesTest.java文件是否为隐藏文件
        System.out.println("FilesTest.java是否为隐藏文件: " + Files.isHidden(Paths.get("src/main/java/org/example/ch15_io/sec_10_nio_2/B_FilesTest.java")));
        // 一次性读取FilesTest.java文件的所有行
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/org/example/ch15_io/sec_10_nio_2/B_FilesTest.java"), Charset.forName("UTF-8"));
        System.out.println(lines);
        // 获取指定文件的大小
        System.out.println("FilesTest.java的大小为: " + Files.size(Paths.get("src/main/java/org/example/ch15_io/sec_10_nio_2/B_FilesTest.java")));

        List<String> poem = new ArrayList<>();
        poem.add("水晶潭底银鱼跃");
        poem.add("清徐风中碧竿横");
        // 直接将多个字符串内容写入指定文件中
        Files.write(Paths.get("data/ch15/10_1_poem.txt"), poem, Charset.forName("UTF-8"));
        // 使用Java 8新增的Stream API读取文件内容
        Files.lines(Paths.get("src/main/java/org/example/ch15_io/sec_10_nio_2/B_FilesTest.java"), Charset.forName("UTF-8"))
                .forEach(line -> System.out.println(line));
        FileStore cStore = Files.getFileStore(Paths.get("C:"));
        // 判断C盘的总空间，可用空间
        System.out.println("C:共有空间: " + cStore.getTotalSpace());
        System.out.println("C:可用空间: " + cStore.getUsableSpace());
    }
}
