package org.example.ch09_generics.sec_01_generics_basics;

import java.util.ArrayList;

public class A_ListErr {
    public static void main(String[] args) {
        // 创建一个只想保存字符串对List集合
        var strList = new ArrayList();
        strList.add("疯狂Java讲义");
        strList.add("疯狂Android讲义");
        // ”不小心“把一个Integer对象"丢进"了集合
        strList.add(5);
        strList.forEach(str -> System.out.println(((String) str).length())); // => ClassCastException
    }
}
