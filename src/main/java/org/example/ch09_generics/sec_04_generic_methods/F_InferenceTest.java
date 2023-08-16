package org.example.ch09_generics.sec_04_generic_methods;

class MyUtil<E> {
    public static <Z> MyUtil<Z> nil() {
        return null;
    }

    public static <Z> MyUtil<Z> cons(Z head, MyUtil<Z> tail) {
        return null;
    }

    E head() {
        return null;
    }
}

public class F_InferenceTest {
    public static void main(String[] args) {
        // 可以通过方法赋值的目标参数来推断泛型为String
        MyUtil<String> ls = MyUtil.nil();
        // 无须使用下面语句在调用nil()方法时指定泛型的类型
        MyUtil<String> mu = MyUtil.<String>nil();
        // 可调用cons()方法所需的参数类型来推断泛型为Integer
        MyUtil.cons(42, MyUtil.nil());
        // 无须使用下面语句在调用nil()方法时指定泛型的类型
        MyUtil.cons(42, MyUtil.<Integer>nil());

        // 希望系统能推断出调用nil()方法时泛型为String类型
        // 但实际上Java 8依然推断不出来，所以下面代码报错
        // String s = MyUtil.nil().head();
        MyUtil.<String>nil().head();
    }
}
