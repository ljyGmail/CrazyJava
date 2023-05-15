package org.example.ch07_basic_api.sec_04_java8_date_time;

import java.util.Date;

public class A_DateTest {
    public static void main(String[] args) {
        var d1 = new Date();
        // 获取当前时间之后100ms的时间
        var d2 = new Date(System.currentTimeMillis() + 100);
        System.out.println(d2);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));
    }
}
