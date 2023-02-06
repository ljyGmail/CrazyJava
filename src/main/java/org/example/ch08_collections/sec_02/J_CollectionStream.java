package org.example.ch08_collections.sec_02;

import java.util.HashSet;

public class J_CollectionStream {
    public static void main(String[] args) {
        var books = new HashSet();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂iOS讲义");
        books.add("疯狂Ajax讲义");
        books.add("疯狂Android讲义");

        // 统计书名包含"疯狂"子串的图书数量
        System.out.println(books.stream()
                .filter(ele -> ((String) ele).contains("疯狂"))
                .count()); // 4
        // 统计书名包含"Java"子串的图书数量
        System.out.println(books.stream()
                .filter(ele -> ((String) ele).contains("Java"))
                .count()); // 2
        // 统计书名字符串长度大于10的图书数量
        System.out.println(books.stream()
                .filter(ele -> ((String) ele).length() > 10)
                .count()); // 2
        // 先调用Collection对象的steam()方法将集合转换为Steam
        // 再调用Stream的mapToInt()方法取原有的Stream对应的IntStream
        books.stream().mapToInt(ele -> ((String) ele).length())
                // 调用forEach()方法遍历IntStream中的每个元素
                .forEach(System.out::println);
    }
}
