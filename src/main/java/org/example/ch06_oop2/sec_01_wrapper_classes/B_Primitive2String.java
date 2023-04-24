package org.example.ch06_oop2.sec_01_wrapper_classes;

import java.util.stream.IntStream;

public class B_Primitive2String {
    public static void main(String[] args) {
        var intStr = "123";
        // 把一个特定字符串转换成int变量
        var it1 = Integer.parseInt(intStr);
        var it2 = Integer.valueOf(intStr);
        System.out.println(it1);
        System.out.println(it2);

        var floatStr = "4.56";
        // 把一个特定字符串转换成float变量
        var ft1 = Float.parseFloat(floatStr);
        var ft2 = Float.valueOf(floatStr);
        System.out.println(ft2);

        // 把一个float变量转换成String变量
        var ftStr = String.valueOf(2.345f);
        System.out.println(ftStr);

        // 把一个double变量转换成String变量
        var dbStr = String.valueOf(3.344);
        System.out.println(dbStr);

        // 把一个boolean变量转换成String变量
        var boolStr = String.valueOf(true);
        System.out.println(boolStr.toUpperCase());

        var intStr2 = 5 + "";
        System.out.println(intStr2);
    }
}
