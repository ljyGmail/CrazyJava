package org.example.ch18_reflection.sec_03_get_class_info_using_reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

class Test {
    public void replace(String str, List<String> list) {
    }
}

public class B_MethodParameterTest {
    public static void main(String[] args) throws Exception {
        // 获取Test的类
        Class<Test> clazz = Test.class;
        // 获取String类的带两个参数的replace()方法
        Method replace = clazz.getMethod("replace", String.class, List.class);
        // 获取指定方法的参数个数
        System.out.println("replace方法参数个数: " + replace.getParameterCount());
        // 获取replace的所有参数信息
        Parameter[] parameters = replace.getParameters();
        var index = 1;
        // 遍历所有参数
        for (var p : parameters) {
            if (p.isNamePresent()) {
                System.out.println("---第" + index++ + "个参数信息---");
                System.out.println("参数名: " + p.getName());
                System.out.println("形参类型: " + p.getType());
                System.out.println("泛型类型: " + p.getParameterizedType());
            }
        }
    }
}
