package org.example.ch08_collections.sec_06_enhanced_map;

import java.util.HashMap;

public class C_NullInHashMap {
    public static void main(String[] args) {
        var hm = new HashMap();
        // 试图将两个key为null值的key-value对放入HashMap中
        hm.put(null, null);
        hm.put(null, null);
        // 将一个value为null的值key-value对放入HashMap中
        hm.put("a", null);
        // 输出Map对象
        System.out.println(hm);
    }
}
