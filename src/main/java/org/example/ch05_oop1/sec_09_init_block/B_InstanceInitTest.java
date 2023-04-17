package org.example.ch05_oop1.sec_09_init_block;

public class B_InstanceInitTest {
    // 先执行实例初始化块将a实例变量赋值为6
    {
        a = 6;
    }

    // 再执行将a实例变量赋值为9
    int a = 9;

    public static void main(String[] args) {
        // 下面代码将输出9
        System.out.println(new B_InstanceInitTest().a);
    }
}
