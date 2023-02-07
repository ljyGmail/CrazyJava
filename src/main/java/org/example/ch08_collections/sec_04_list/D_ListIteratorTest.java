package org.example.ch08_collections.sec_04_list;

import java.util.ArrayList;

public class D_ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {
                "疯狂Java讲义", "疯狂iOS讲义",
                "轻量级Java EE企业应用实战"
        };
        var bookList = new ArrayList();
        for (var i = 0; i < books.length; i++) {
            bookList.add(books[i]);
        }

        var lit = bookList.listIterator();
        // 从前向后遍历
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.add("-------分隔符-------");
        }

        System.out.println("下面开始反向迭代");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
    }
}
