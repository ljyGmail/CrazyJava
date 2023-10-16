package org.example.ch14_annotation.sec_01_basic_annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class D_ErrorUtils {
    @SafeVarargs
    public static void faultyMethod(List<String>... listStrArray) {
        // Java语言不允许创建泛型数组，因此listArray只能被当成List[]处理
        // 此时相当于把List<String>赋给了List，已经发生了"堆污染"
        List[] listArray = listStrArray;
        List<Integer> myList = new ArrayList<>();
        myList.add(new Random().nextInt(100));
        // 把listArray的第一个元素赋为myArray
        listArray[0] = myList;
        String s = listStrArray[0].get(0);
    }
}
