package org.example.ch09_generics.sec_05_generics_erasure;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

public class B_ErasureTest2 {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(6);
        li.add(9);
        List list = li;
        // 下面代码引起"未经检查的转换"警告，编译运行时完全正常
        List<String> ls = list;
        // 但只要访问ls里的元素，如下面代码将引起运行时异常
        // System.out.println(ls.get(0)); // ClassCastException
    }
}
