package org.example.ch07_basic_api.sec_05_regular_expression;

import java.util.Arrays;

public class E_StringReg {
    public static void main(String[] args) {
        String[] msgs = {
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in Java",
                "Java represses oracular expressions",
        };

        for (var msg : msgs) {
            System.out.println(msg.replaceFirst("re\\w*", "哈哈:)"));
            System.out.println(Arrays.toString(msg.split(" ")));
        }
    }
}
