package org.example.ch10_exception_handling.sec_04_throw_exception_using_throw;

public class B_AuctioinException extends Exception {
    // 无参数的构造器
    public B_AuctioinException() {
    }

    // 带一个字符串参数的构造器
    public B_AuctioinException(String msg) {
        super(msg);
    }
}
