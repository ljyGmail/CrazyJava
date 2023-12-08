package org.example.ch18_reflection.sec_04_operate_objects_using_reflection;

import java.lang.reflect.Constructor;

public class B_CreateJFrame {
    public static void main(String[] args) throws Exception {
        // 获取JFrame对象的Clazz对象
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
        // 获取JFrame中带一个字符串参数的构造器
        Constructor ctor = jframeClazz.getConstructor(String.class);
        // 调用Constructor的newInstance方法创建对象
        Object obj = ctor.newInstance("参数窗口");
        // 输出JFrame对象
        System.out.println(obj);
    }
}
