package org.example.ch08_collections.sec_06_enhanced_map;

import java.util.LinkedHashMap;

public class F_LinkedHashMapTest {
    public static void main(String[] args) {
        var scores = new LinkedHashMap();
        scores.put("语文", 80);
        scores.put("英文", 82);
        scores.put("数学", 86);
        // 调用forEach()方法遍历scores里的所有key-value对
        scores.forEach((key, value) -> System.out.println(key + "-->" + value));
    }
}
