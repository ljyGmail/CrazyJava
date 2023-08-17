package org.example.ch10_exception_handling.sec_03_checked_runtime_exception_hierarchy;

import java.io.FileInputStream;
import java.io.IOException;

public class C_OverrideThrows {
    public void test() throws IOException {
        var fis = new FileInputStream("a.txt");
    }
}

class Sub extends C_OverrideThrows {
    // 子类方法声明抛出了比父类方法更大的异常
    // 所以下面方法有错
    /*
    @Override
    public void test() throws Exception {
    }
    */
}