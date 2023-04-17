package org.example.ch05_oop1.sec_09_init_block;

public class D_StaticInitTest {
    // 先执行类初始化块将类变量a赋值为6
    static {
        a = 6;
    }

    // 再将类变量a赋值为9
    static int a = 9;

    public static void main(String[] args) {
        // 下面代码将输出9
        System.out.println(D_StaticInitTest.a);
    }
}
