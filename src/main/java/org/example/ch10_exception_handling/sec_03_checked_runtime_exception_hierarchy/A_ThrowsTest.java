package org.example.ch10_exception_handling.sec_03_checked_runtime_exception_hierarchy;

import java.io.FileInputStream;
import java.io.IOException;

public class A_ThrowsTest {
    public static void main(String[] args) throws IOException {
        var fis = new FileInputStream("a.txt");
    }
}
