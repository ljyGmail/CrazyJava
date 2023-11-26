package org.example.ch16_multi_threading.sec_02_create_start_threads;

public class B_SecondThread implements Runnable {
    private int i;

    // run()方法同样时线程执行体
    @Override
    public void run() {
        // 当线程类实现Runnable接口时
        // 如果向获取当前线程，只能用Thread.currentThread()方法
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (var i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                var st = new B_SecondThread();
                // 通过new Thread(target, name)方法创建新线程
                new Thread(st, "Thread1").start();
                new Thread(st, "Thread2").start();
            }
        }
    }
}
