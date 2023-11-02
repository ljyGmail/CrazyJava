package org.example.ch14_annotation.sec_01_basic_annotation;

class Orange {
    // 定义info方法已过时
    // since属性指定从哪个版本开始，forRemoval指定该API将来会被删除
    @Deprecated(since = "9", forRemoval = true)
    public void info() {
        System.out.println("Orange的info方法");
    }
}

public class B_DeprecatedTest {
    public static void main(String[] args) {
        // 下面使用info()方法时将会被编译器警告
        new Orange().info();
    }
}

