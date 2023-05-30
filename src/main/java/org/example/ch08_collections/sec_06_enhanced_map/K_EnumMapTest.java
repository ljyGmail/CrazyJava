package org.example.ch08_collections.sec_06_enhanced_map;

import java.util.EnumMap;

enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class K_EnumMapTest {
    public static void main(String[] args) {
        // 创建EnumMap对象，该EnumMap的所有key都是Season枚举类的枚举值
        var enumMap = new EnumMap(Season.class);
        enumMap.put(Season.SUMMER, "夏日炎炎");
        enumMap.put(Season.SPRING, "春暖花开");
        System.out.println(enumMap);
    }
}
