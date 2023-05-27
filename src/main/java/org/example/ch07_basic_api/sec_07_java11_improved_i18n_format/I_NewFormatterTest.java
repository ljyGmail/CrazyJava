package org.example.ch07_basic_api.sec_07_java11_improved_i18n_format;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class I_NewFormatterTest {

    public static void main(String[] args) {
        var formatters = new DateTimeFormatter[]{
                // 直接使用常量创建DateFormatter格式器
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                // 使用本地化的不同风格来创建DateTimeFormatter格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
//                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG),
                // 根据模式字符串来创建DateTimeFormatter格式器
//                DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss")
        };
        var date= LocalDateTime.now();
        // 依次使用不同的格式器对LocalDateTime进行格式化
        for(var i=0;i<formatters.length;i++)
        {
            // 下面两行代码的作用相同
            System.out.println(date.format(formatters[i]));
            System.out.println(formatters[i].format(date));
        }
    }
}
