package org.example.ch16_multi_threading.sec_04_control_of_threads;

import java.util.Date;

public class C_SleepTest {
    public static void main(String[] args) throws Exception {
        for (var i = 0; i < 10; i++) {
            System.out.println("当前时间: " + new Date());
            // 调用sleep()方法让当前线程暂停1s
            Thread.sleep(1000);
        }
    }
}
