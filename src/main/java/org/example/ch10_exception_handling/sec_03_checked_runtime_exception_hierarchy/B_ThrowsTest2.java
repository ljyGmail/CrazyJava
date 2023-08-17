package org.example.ch10_exception_handling.sec_03_checked_runtime_exception_hierarchy;

import java.io.FileInputStream;
import java.io.IOException;

public class B_ThrowsTest2 {
    public static void main(String[] args) throws Exception {
        // 因为test()方法声明抛出IOException异常
        // 所以调用该方法的代码要么处于try...catch块中
        // 要么处于另一个带throws声明抛出的方法中
        test();
    }

    public static void test() throws IOException {
        // 因为FileInputStream的构造器声明抛出IOException异常
        // 所以调用FileInputStream的代码要么处于try...catch块中
        // 要么处于另一个带throws声明抛出的方法中
        var fis = new FileInputStream("a.txt");
    }
}
