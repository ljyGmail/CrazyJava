package org.example.ch09_generics.sec_02_generics_going_deeper;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class D_R<T> {
    // 下面代码错误，不能在静态变量声明中使用泛型
    // static T info;
    T age;

    public void foo(T msg) {
    }

    // 下面代码错误，不能在静态方法声明中使用泛型形参
    /*
    public static void bar(T msg) {
    }
    */

    public static void main(String[] args) {
        // 分别创建List<String>对象和List<Integer>对象
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        // 调用getClass()方法来比较l1和l2的类是否相等
        System.out.println(l1.getClass() == l2.getClass());

        Collection<String> cs = new ArrayList<>();
        Collection<Integer> in = new ArrayList<>();
        if (cs instanceof ArrayList<String>) {
            System.out.println("cs is an ArrayList<String>");
        }
    }
}
