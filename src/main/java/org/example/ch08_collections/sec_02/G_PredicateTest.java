package org.example.ch08_collections.sec_02;

import java.util.HashSet;

public class G_PredicateTest {
    public static void main(String[] args) {
        // 创建一个集合
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂iOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");
        // 使用Lambda表达式(目标类型是Predicate)过滤集合
        books.removeIf(ele -> ((String) ele).length() < 10);
        System.out.println(books);
    }
}
