package org.example.ch06_oop2.sec_10_gc;

public class A_StatusTransfer {
    public static void test() {
        var a = new String("轻量级Java EE企业应用实战");
        a = new String("疯狂Java讲义");
    }

    public static void main(String[] args) {
        test();
    }
}
