package org.example.ch14_annotation.sec_03_customized_annotations;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.List;

// 定义一个简单的类型注解，不带任何成员变量
@Target(ElementType.TYPE_USE)
@interface NotNull {
}

// 定义类时使用类型注解
@NotNull
public class K_TypeAnnotationTest implements /* implements时使用类型注解 */ Serializable {
    // 方法形参使用类型注解
    public static void main(@NotNull String[] args)
    // throws时使用类型注解
            throws @NotNull FileNotFoundException {
        Object obj = "fkjava.org";
        // 强制类型转换时使用类型注解
        String str = (@NotNull String) obj;
        // 创建对象时使用类型注解
        Object win = new @NotNull JFrame("疯狂软件");
    }

    // 泛型中使用类型注解
    public void foo(List<@NotNull String> info) {
    }
}
