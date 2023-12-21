package org.example.ch18_reflection.sec_06_reflection_and_generics;

public class A_CrazyitObjectFactory {
    public static Object getInstance(String clsName) {
        try {
            // 创建指定类对应的Class对象
            Class cls = Class.forName(clsName);
            // 返回使用该Class对象创建的实例
            return cls.getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
