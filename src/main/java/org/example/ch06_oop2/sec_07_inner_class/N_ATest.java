package org.example.ch06_oop2.sec_07_inner_class;

interface A {
    void test();
}

public class N_ATest {
    public static void main(String[] args) {
        int age = 8;

        var a = new A() {
            public void test() {
                // 在Java 8以前下面语句将提示错误，age必须使用final修饰
                // 从Java 8开始，匿名内部类，局部内部类允许访问非final的局部变量
                System.out.println(age);

                // 下面代码将会导致编译错误
                // 由于age局部变量被匿名内部类访问了，因此age相当于被final修饰了
                // age = 2;
            }
        };
        a.test();
    }
}
