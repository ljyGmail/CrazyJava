package org.example.ch07_basic_api.sec_07_java11_improved_i18n_format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class H_SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        var d=new Date();
        // 创建一个SimpleDateFormat对象
        var sdf1=new SimpleDateFormat("Gyyyy年中第D天");
        // 将d格式化成日期，输出
        var dateStr=sdf1.format(d);
        System.out.println(dateStr);
        // 一个非常特殊的日期字符串
        var str="14###3월##21";
        var sdf2=new SimpleDateFormat("y###MMM##d");
        // 将日期字符串解析成日期，输出
        System.out.println(sdf2.parse(str));
    }
}
