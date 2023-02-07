package org.example.ch08_collections.sec_04_list;

import java.util.ArrayList;

class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class B_ListTest2 {
    public static void main(String[] args) {
        var books = new ArrayList();
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        System.out.println(books);
        // 删除集合中的A对象，将导致第一个元素被删除
        books.remove(new A());
        System.out.println(books);
        // 输出集合中的A对象，再次删除集合中的第一个元素
        books.remove(new A());
        System.out.println(books);
    }
}
