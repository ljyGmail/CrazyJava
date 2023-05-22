package org.example.ch07_basic_api.sec_07_java11_improved_i18n_format;

import java.util.Locale;

public class A_LocaleList {
    public static void main(String[] args) {
        // 所有Java所支持的全部国家和语言的数组
        Locale[] localeList = Locale.getAvailableLocales();
        // 遍历数组的每个元素，依次获取所支持的国家和语言
        for (var i = 0; i < localeList.length; i++) {
            // 输出所支持的国家和语言
            if(localeList[i].getCountry().equals("KR"))
            System.out.println(localeList[i].getDisplayCountry()
                    + "=" + localeList[i].getCountry() + " "
                    + localeList[i].getDisplayLanguage()
                    + "=" + localeList[i].getLanguage());
        }
    }
}
