package org.example.ch08_collections.sec_03_set;

import java.util.TreeSet;

class Err {
}

public class E_TreeSetErrorTest {
    public static void main(String[] args) {
        var ts = new TreeSet();
        // 向TreeSet集合中添加Err对象
        ts.add(new Err());
        // 集合元素必须实现Comparable接口，否则将抛出ClassCastException
    }
}
