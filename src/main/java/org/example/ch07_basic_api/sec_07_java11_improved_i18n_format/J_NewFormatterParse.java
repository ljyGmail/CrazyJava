package org.example.ch07_basic_api.sec_07_java11_improved_i18n_format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class J_NewFormatterParse {
    public static void main(String[] args) {
        // 定义一个任意格式的日期，时间字符串
        var str1 = "2014==04==12 01::06::09";
        // 根据需要解析的日期，时间字符串定义解析所用的格式器
        var formatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH::mm::ss");
        // 执行解析
        var dt1 = LocalDateTime.parse(str1, formatter1);
        System.out.println(dt1); // 输出 2014-04-12T01:06:09
        // ---下面代码再次解析另一个字符串---
        var str2 = "2014$$$04$$$13 20";
        var formatter2 = DateTimeFormatter.ofPattern("yyyy$$$MM$$$dd HH");
        var dt2 = LocalDateTime.parse(str2, formatter2);
        System.out.println(dt2);
    }
}
