package org.example.ch09_generics.sec_03_type_wildcard;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class A_ArrayErr {
    public static void main(String[] args) {
        // 定义一个Integer数组
        Integer[] ia = new Integer[5];
        // 可以把一个Integer[]数组赋给Number[]变量
        Number[] na = ia;
        // 下面代码编译正常，但运行时会引发ArrayStoreException异常
        // 因为0.5并不是Integer
        // na[0] = 0.5;

        List<Integer> iList = new ArrayList<>();
        // 下面代码导致编译错误
        // List<Number> nList = iList;

        List<?> c = new ArrayList<String>();
        // 下面程序引起编译错误
        // c.add(new Object());
    }
}
