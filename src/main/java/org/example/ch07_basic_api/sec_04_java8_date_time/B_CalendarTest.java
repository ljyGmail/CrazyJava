package org.example.ch07_basic_api.sec_04_java8_date_time;

import java.util.Calendar;

public class B_CalendarTest {
    public static void main(String[] args) {
        var c = Calendar.getInstance();
        // 取出年
        System.out.println(c.get(Calendar.YEAR));
        // 取出月份
        System.out.println(c.get(Calendar.MONTH));
        // 取出日
        System.out.println(c.get(Calendar.DATE));
        // 分别设置年，月，日，小时，分钟，秒
        c.set(2003, 10, 23, 12, 32, 23); // 2003-11-23 23:32:23
        System.out.println(c.getTime());
        // 将Calendar的月前推8个月
        c.roll(Calendar.MONTH, -8); // 2002-03-23 12:32:23
        System.out.println(c.getTime());
    }
}
