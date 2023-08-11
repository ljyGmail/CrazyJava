package org.example.ch09_generics.sec_03_type_wildcard;

import java.util.ArrayList;
import java.util.Collection;

public class F_MyUtils {
    // 下面dest集合元素的类型必须与src集合元素的类型相同，或者是父类
    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (var ele : src){
            last = ele;
            // 逆变的泛型集合添加元素是安全的
            dest.add(ele);
        }
        return last;
    }

    public static void main(String[] args) {
        var ln = new ArrayList<Number>();
        var li = new ArrayList<Integer>();
        li.add(5);
        // 此处可准确地知道最后一个被复制的元素是Integer类型
        // 与src集合元素的类型相同
        Integer last = copy(ln, li);
        System.out.println(ln);
    }
}
