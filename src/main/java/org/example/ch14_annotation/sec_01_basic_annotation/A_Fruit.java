package org.example.ch14_annotation.sec_01_basic_annotation;

public class A_Fruit {
    public void info() {
        System.out.println("水果的info方法...");
    }
}

class Apple extends A_Fruit {

    // 使用@Override指定下面方法必须重写父类方法
    @Override
    public void info() {
        System.out.println("苹果重写水果的info方法...");
    }
}
