package org.example.ch07_basic_api.sec_07_java11_improved_i18n_format;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class G_DateFormatTest {
    public static void main(String[] args) throws ParseException {
        // 需要被格式化的时间
        var dt = new Date();
        // 创建两个Locale，分别代表中国，美国
        Locale[] locales = {Locale.CHINA, Locale.US};
        var df = new DateFormat[16];
        // 为上面两个Locale创建16个DateFormat对象
        for (var i = 0; i < locales.length; i++) {
            df[i * 8] = DateFormat.getDateInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 1] = DateFormat.getDateInstance(DateFormat.MEDIUM, locales[i]);
            df[i * 8 + 2] = DateFormat.getDateInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 3] = DateFormat.getDateInstance(DateFormat.FULL, locales[i]);
            df[i * 8 + 4] = DateFormat.getTimeInstance(DateFormat.SHORT, locales[i]);
            df[i * 8 + 5] = DateFormat.getTimeInstance(DateFormat.MEDIUM, locales[i]);
            df[i * 8 + 6] = DateFormat.getTimeInstance(DateFormat.LONG, locales[i]);
            df[i * 8 + 7] = DateFormat.getTimeInstance(DateFormat.FULL, locales[i]);
        }

        for (var i = 0; i < locales.length; i++) {
            var tip = i == 0 ? "----中国日期格式----" : "----美国日期格式----";
            System.out.println(tip);
            System.out.println("SHORT格式的日期格式: " + df[i * 8].format(dt));
            System.out.println("MEDIUM格式的日期格式: " + df[i * 8 + 1].format(dt));
            System.out.println("LONG格式的日期格式: " + df[i * 8 + 2].format(dt));
            System.out.println("FULL格式的日期格式: " + df[i * 8 + 3].format(dt));
            System.out.println("SHORT格式的时间格式: " + df[i * 8 + 4].format(dt));
            System.out.println("MEDIUM格式的时间格式: " + df[i * 8 + 5].format(dt));
            System.out.println("LONG格式的时间格式: " + df[i * 8 + 6].format(dt));
            System.out.println("FULL格式的时间格式: " + df[i * 8 + 7].format(dt));
        }

//        var str1="2017/10/07";
//        var str2="2017년10월07일";
//        System.out.println(DateFormat.getDateInstance().parse(str2));
//        System.out.println(DateFormat.getDateInstance(DateFormat.FULL).parse(str1));
    }
}
