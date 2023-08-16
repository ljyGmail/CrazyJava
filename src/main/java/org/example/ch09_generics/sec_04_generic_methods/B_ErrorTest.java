package org.example.ch09_generics.sec_04_generic_methods;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class B_ErrorTest {
    // 声明一个泛型方法，该泛型方法中带一个T泛型形参
    static <T> void test(Collection<T> from, Collection<T> to) {
        for (var ele : from) {
            to.add(ele);
        }
    }

    public static void main(String[] args) {
        List<Object> ao = new ArrayList<>();
        List<String> as  = new ArrayList<>();
        // 下面代码将产生编译错误
        // test(ao, as);
    }
}
