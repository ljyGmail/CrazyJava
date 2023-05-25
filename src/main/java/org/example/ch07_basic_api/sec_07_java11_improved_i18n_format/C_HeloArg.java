package org.example.ch07_basic_api.sec_07_java11_improved_i18n_format;

import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class C_HeloArg {
    public static void main(String[] args) {
        // 定义一个Locale变量
        Locale currentLocale = null;
        // 如果运行程序指定了两个参数
        if (args.length == 2) {
            // 使用运行程序的两个参数构造Locale实例
            currentLocale = new Locale(args[0], args[1]);
        } else {
            // 否则直接使用系统默认的Locale
            currentLocale = Locale.getDefault(Locale.Category.FORMAT);
        }
        // 根据Locale加载语言资源
        var bundle = ResourceBundle.getBundle("myMess", currentLocale);
        // 取得已加载的语言资源文件中msg对应消息
        var msg = bundle.getString("msg");
        // 使用MessageFormat为带占位符的字符串传入参数
        System.out.println(MessageFormat.format(msg, "자바", new Date()));
    }
}
