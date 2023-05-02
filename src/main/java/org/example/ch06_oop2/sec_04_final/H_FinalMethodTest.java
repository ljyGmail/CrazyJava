package org.example.ch06_oop2.sec_04_final;

public class H_FinalMethodTest {
    public final void test() {
    }
}

class Sub extends H_FinalMethodTest {
    // 下面方法定义将出现编译错误，不能重写final方法
//    public void test() {
//    }
}
