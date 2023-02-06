package org.example.ch08_collections.sec_03_set;

import java.util.Date;
import java.util.TreeSet;

public class F_TreeSetErrorTest2 {
    public static void main(String[] args) {
        var ts = new TreeSet();
        // 向TreeSet集合中添加两个对象
        ts.add(new String("疯狂Java讲义"));
        ts.add(new Date());
        // 向TreeSet添加元素必须是同一类对象，否则也会引发ClassCastException
    }
}
