package org.example.ch05_oop1.sec_02_methods;

public class F_OverloadVarargs {
    public void test(String msg) {
        System.out.println("只有一个字符串参数的test方法");
    }

    // 因为前面已经有了一个test()方法，test()方法里有一个字符串参数
    // 此处的个数可变形参里不包含一个字符串参数的形式
    public void test(String... books) {
        System.out.println("****形参个数可变的test方法****");
    }

    public static void main(String[] args) {
        var olv = new F_OverloadVarargs();
        // 下面两次调用将执行第二个test()方法
        olv.test();
        olv.test("aa", "bb");
        // 下面调用将执行第一个test()方法
        olv.test("aa");
        // 下面调用执行第二个test()方法
        olv.test(new String[]{"aa"});
    }

}
