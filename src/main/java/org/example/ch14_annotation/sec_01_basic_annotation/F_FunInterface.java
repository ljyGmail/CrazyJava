package org.example.ch14_annotation.sec_01_basic_annotation;

@FunctionalInterface
public interface F_FunInterface {
    static void foo() {
        System.out.println("foo类方法");
    }

    default void bar() {
        System.out.println("bar默认方法");
    }

    void test(); // 只定义一个抽象方法
}
