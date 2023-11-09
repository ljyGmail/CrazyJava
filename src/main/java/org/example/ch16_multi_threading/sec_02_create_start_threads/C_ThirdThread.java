package org.example.ch16_multi_threading.sec_02_create_start_threads;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class C_ThirdThread {
    public static void main(String[] args) {
        // 创建Callable对象
        var rt = new C_ThirdThread();
        // 先使用Lambda表达式创建Callable<Integer>对象
        // 使用FutureTask来包装Callable对象
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
            var i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " 的循环变量i的值: " + i);
            }
            // call()方法可以有返回值
            return i;
        });

        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值: " + i);
            if (i == 20) {
                // 实质还是以Callable对象来创建并启动线程的
                new Thread(task, "有返回值的线程").start();
            }
        }

        try {
            // 获取线程返回值
            System.out.println("子线程的返回值: " + task.get());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
