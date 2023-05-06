package org.example.ch06_oop2.sec_07_inner_class;

public class E_InnerNoStatic {
    private class InnerClass {
        /*
        下面三个静态声明都将引发如下编译错误:
        非静态内部类不能有静态声明
        *但在Java16以后可以定义静态成员...*
         */
        static {
            System.out.println("===========");
        }

        private static int inProp;

        private static void test() {
            System.out.println("xxx");
        }
    }

    public void test(){
        System.out.println(InnerClass.inProp);
        InnerClass.test();
    }

    public static void main(String[] args) {
        new E_InnerNoStatic().test();
    }
}
