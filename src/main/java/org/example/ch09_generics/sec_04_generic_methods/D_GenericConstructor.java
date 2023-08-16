package org.example.ch09_generics.sec_04_generic_methods;

class Foo {
    public <T> Foo(T t) {
        System.out.println(t);
    }
}

public class D_GenericConstructor {
    public static void main(String[] args) {
        // 泛型构造器中的T类型为String
        new Foo("疯狂Java讲义");
        // 泛型构造器中的T类型为Integer
        new Foo(200);
        // 显示指定泛型构造器中的T类型为String
        // 传给Foo构造器的实参也是String对象，完全正确
        new <String>Foo("疯狂Android讲义");

        // 显示指定泛型构造器中的T类型为String，
        // 但传给Foo构造器的实参是Double对象，下面代码出错
        // new <String> Foo(12.3);
    }
}
