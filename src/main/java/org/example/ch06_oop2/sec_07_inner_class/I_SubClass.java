package org.example.ch06_oop2.sec_07_inner_class;

public class I_SubClass extends Out.In {
    // 显式定义SubClass的构造器
    public I_SubClass(Out out) {
        // 通过传入的Out对象显式调用In的构造器
        out.super("hello");
    }
}
