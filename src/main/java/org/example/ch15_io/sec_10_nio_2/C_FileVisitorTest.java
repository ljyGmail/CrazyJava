package org.example.ch15_io.sec_10_nio_2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class C_FileVisitorTest {
    public static void main(String[] args) throws Exception {
        // 遍历data目录下的所有文件和子目录
        Files.walkFileTree(Paths.get("data"), new SimpleFileVisitor<>() {
            // 访问文件时触发该方法
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问" + file + "文件");
                // 找到了FileVisitorTest.java文件
                if (file.endsWith("FileVisitorTest.java")) {
                    System.out.println("--已经找到目标文件--");
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            // 开始访问目录时触发该方法
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问: " + dir + "路径");
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
