package org.example.ch09_generics.sec_06_generic_and_array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class A_GenericAndArray {
    /*
    <T> T[] makeArray(Collection<T> coll) {
        // 下面代码导致编译错误
        return new T[coll.size()];
    }
     */

    public static void main(String[] args) {
        // 下面代码编译时有"[unchecked]未经检查的转换"警告
        /*
        List<String>[] lsa = new ArrayList[10];
        // 将lsa向上转型为Object[]类型的变量
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<>();
        li.add(3);
        oa[1] = li;
        */
        // 下面代码引起ClassCastException异常
        // String s = lsa[1].get(0);

        List<?>[] lsa = new ArrayList<?>[10];
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<>();
        li.add(3);
        oa[1] = li;
        Object target = lsa[1].get(0);
        if(target instanceof String){
            // 下面代码安全了
            var s = (String) target;
        }
    }
}
