package org.example.ch16_multi_threading.sec_08_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A_ThreadPoolTest {
    public static void main(String[] args) {
        // 创建一个具有固定线程数(6)的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // 使用Lambda表达式创建Runnable对象
        Runnable target = () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "的值为: " + i);
            }
        };
        // 向线程池中提交两个线程
        pool.submit(target);
        pool.submit(target);
        // 关闭线程池
        pool.shutdown();
    }
}
