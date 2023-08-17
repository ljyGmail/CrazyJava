package org.example.ch10_exception_handling.sec_04_throw_exception_using_throw;

public class E_SalException extends Exception {
    public E_SalException() {
    }

    public E_SalException(String msg) {
        super(msg);
    }

    // 创建一个可以接收Throwable参数的构造器
    public E_SalException(Throwable t) {
        super(t);
    }
}
