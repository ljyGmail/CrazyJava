package org.example.ch18_reflection.sec_05_dynamic_proxy;

public class D_GunDog implements B_Dog {
    // 实现info()方法，仅仅打印一个字符串
    @Override
    public void info() {
        System.out.println("我是一只猎狗");
    }

    // 实现run()方法，仅仅打印一个字符串
    @Override
    public void run() {
        System.out.println("我奔跑迅速");
    }
}
