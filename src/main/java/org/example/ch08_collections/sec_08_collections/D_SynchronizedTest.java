package org.example.ch08_collections.sec_08_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class D_SynchronizedTest {
    public static void main(String[] args) {
        // 下面程序创建了4个线程安全的集合对象
        var c = Collections.synchronizedCollection(new ArrayList());
        var list = Collections.synchronizedList(new ArrayList());
        var s = Collections.synchronizedSet(new HashSet());
        var m = Collections.synchronizedMap(new HashMap());
    }
}
