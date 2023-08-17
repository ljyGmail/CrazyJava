package org.example.ch10_exception_handling.sec_04_throw_exception_using_throw;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class D_ThrowTest2 {
    public static void main(String[] args)
        // Java 6认为1处代码可能抛出Exception
        // 所以此处必须声明抛出Exception
        // Java 7会检查1处代码可能抛出异常的实际类型
        // 因此此处只需声明抛出FileNotFoundException即可
            throws FileNotFoundException {
        try {
            new FileOutputStream("a.txt");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex; // 1
        }
    }
}
