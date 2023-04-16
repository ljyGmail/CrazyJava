package org.example.ch05_oop1.sec_07_polymorphism;

import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;

class BaseClass {
    public int book = 6;

    public void base() {
        System.out.println("父类的普通方法");
    }

    public void test() {
        System.out.println("父类的被覆盖的方法");
    }
}

public class A_SubClass extends BaseClass {
    // 重新定义一个book实例变量隐藏父类的book实例变量
    public String book = "轻量级Java EE企业应用实战";

    public void test() {
        System.out.println("子类的覆盖父类的方法");
    }

    public void sub() {
        System.out.println("子类的普通方法");
    }

    public static void main(String[] args) {
        // 下面编译时类型和运行时类型完全一样，因此不存在多态
        BaseClass bc = new BaseClass();
        // 输出6
        System.out.println(bc.book);
        // 下面两次调用将执行BaseClass的方法
        bc.base();
        bc.test();
        // 下面编译时类型和运行时类型完全一样，因此不存在多态
        A_SubClass sc = new A_SubClass();
        // 输出"轻量级Java EE企业应用实战"
        System.out.println(sc.book);
        // 下面调用将执行从父类继承到的base()方法
        sc.base();
        // 下面调用将执行当前类的test()方法
        sc.test();
        // 下面编译时类型和运行时类型不一样，多态发生
        BaseClass polymohicBc = new A_SubClass();
        // 输出6: 表明访问的是父类的实例变量
        System.out.println(polymohicBc.book);
        // 下面调用将执行从父类继承到的base()方法
        polymohicBc.base();
        // 下面调用将执行当前类的test()方法
        polymohicBc.test();
        // 因为polymophicBc的编译时类型是BaseClass
        // BaseClass类没有提供sub()方法，所以下面代码编译时会出现错误
        // polymohicBc.sub();

        // 编译器推断出v1时SubClass类型
        var v1 = new A_SubClass();
        // 由于popymophicBc的编译时类型时BaseClass
        // 因此编译器推断出v2时BaseClass类型
        var v2 = polymohicBc;
        // 由于BaseClass没有提供sub方法，所以下面代码编译时会出现错误
        // v2.sub();
    }
}
