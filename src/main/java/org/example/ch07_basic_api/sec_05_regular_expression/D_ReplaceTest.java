package org.example.ch07_basic_api.sec_05_regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D_ReplaceTest {
    public static void main(String[] args) {
        String[] msgs = {
                "Java has regular expression in 1.4",
                "regular expressions now expressing in Java",
                "Java represses oracular expressions",
        };
        var p = Pattern.compile("re\\w*");
        Matcher matcher=null;
        for(var i=0;i<msgs.length; i++){
            if(matcher==null){
                matcher=p.matcher(msgs[i]);
            }else {
                matcher.reset(msgs[i]);
            }
            System.out.println(matcher.replaceAll("哈哈:)"));
        }
    }
}
