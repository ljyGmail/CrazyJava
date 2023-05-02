package org.example.ch06_oop2.sec_04_final;

public class I_PrivateFinalMethodTest {
    private final void test() {
    }
}

class Sub2 extends I_PrivateFinalMethodTest {
    // 下面的方法定义不会出现问题
    public void test() {
    }
}
