package org.example.ch18_reflection.sec_06_reflection_and_generics;

import javax.swing.*;
import java.util.Date;

public class B_CrazyObjectFactory2 {
    public static <T> T getInstance(Class<T> cls) {
        try {
            return cls.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // 获取实例后无须类型转换
        Date d = B_CrazyObjectFactory2.getInstance(Date.class);
        JFrame f = B_CrazyObjectFactory2.getInstance(JFrame.class);
    }
}
