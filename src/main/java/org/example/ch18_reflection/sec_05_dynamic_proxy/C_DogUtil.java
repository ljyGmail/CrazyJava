package org.example.ch18_reflection.sec_05_dynamic_proxy;

public class C_DogUtil {
    // 第一个拦截器方法
    public void method1() {
        System.out.println("=====模拟第一个通用方法=====");
    }

    // 第二个拦截器方法
    public void method2() {
        System.out.println("=====模拟第二个通用方法=====");
    }
}
