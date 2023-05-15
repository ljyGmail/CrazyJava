package org.example.ch07_basic_api.sec_04_java8_date_time;

import java.util.Calendar;

public class C_LenientTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        // 结果是YEAR字段加1，MONTH字段为1(2月)
        cal.set(Calendar.MONTH, 13);
        System.out.println(cal.getTime());
        // 关闭容错性
        cal.setLenient(false);
        // 导致运行时异常
        cal.set(Calendar.MONTH, 13);
        System.out.println(cal.getTime());
    }
}
