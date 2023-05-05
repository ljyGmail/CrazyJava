package org.example.ch06_oop2.sec_06_java9_improved_interface;

public class F_OutputFactory {
    public A_Output getOutput() {
//        return new D_Printer();
        return new G_BetterPrinter();
    }

    public static void main(String[] args) {
        var of = new F_OutputFactory();
        var c = new E_Computer(of.getOutput());
        c.keyIn("轻量级Java EE 企业应用实战");
        c.keyIn("疯狂Java讲义");
        c.print();
    }
}
