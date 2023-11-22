package org.example.ch16_multi_threading.sec_07_threadgroup_and_unhandled_exception;

// 定义自己的异常处理器
class MyExHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + " 线程出现了异常: " + e);
    }
}

public class B_ExHandler {
    public static void main(String[] args) {
        // 设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        var a = 5 / 0;
        System.out.println("程序正常结束!");
    }
}
