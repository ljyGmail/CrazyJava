package org.example.ch09_generics.sec_01_generics_basics;

interface Foo<T> {
    void test(T t);
}

public class D_AnonymousDiamond {
    public static void main(String[] args) {
        // 指定Foo类中泛型为String
        Foo<String> f = new Foo<>() {
            // test()方法的参数类型为String
            @Override
            public void test(String t) {
                System.out.println("test方法的t参数为: " + t);
            }
        };
        // 使用泛型通配符，此时相当于通配符的上限为Object
        Foo<?> fo = new Foo<>() {
            // test()方法的参数类型为Object
            @Override
            public void test(Object t) {
                System.out.println("test方法的Object参数为: " + t);
            }
        };
        // 使用泛型通配符，通配符的上限为Number
        Foo<? extends Number> fn = new Foo<>() {
            // 此时test()方法的参数类型为Number
            @Override
            public void test(Number t) {
                System.out.println("test方法的Number参数为: " + t);
            }
        };
    }
}
