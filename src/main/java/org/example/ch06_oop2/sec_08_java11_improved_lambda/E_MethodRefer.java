package org.example.ch06_oop2.sec_08_java11_improved_lambda;

import javax.swing.*;
import java.util.Comparator;
import java.util.concurrent.Flow;

@FunctionalInterface
interface Converter {
    Integer convert(String from);
}

@FunctionalInterface
interface MyTest {
    String test(String a, int b, int c);
}

@FunctionalInterface
interface YourTest {
    JFrame win(String title);
}

public class E_MethodRefer {
    public static void main(String[] args) {
        // 1. 引用类方法
        // 下面代码使用Lambda表达式创建Converter对象
        // Converter converter = from -> Integer.valueOf(from);
        // Integer val = converter.convert("99");
        // System.out.println(val); // 输出整数99
        // 方法引用代替Lambda表达式: 引用类方法
        // 函数式接口中被实现方法的全部参数传给该类方法作为参数
        Converter converter = Integer::valueOf;
        Integer val = converter.convert("98");
        System.out.println(val);

        // 2. 引用特定对象的实例方法
        // 下面代码使用Lambda表达式创建Converter对象
        // Converter converter2 = from -> "fkit.org".indexOf(from);
        // Integer value = converter2.convert("it");
        // System.out.println(value);
        // 方法引用代替Lambda表达式：引用特定对象的实例方法
        // 函数式接口中被实现方法的全部参数传给该方法作为参数
        Converter converter2 = "fkit.org"::indexOf;
        Integer value = converter2.convert("it");
        System.out.println(value);

        // 3. 引用某类对象的实例方法
        // MyTest mt = ((a, b, c) -> a.substring(b, c));
        // String str = mt.test("Java I Love you", 2, 9);
        // System.out.println(str); // 输出: va I Lo
        // 方法引用代替Lambda表达式：引用某类对象的实例方法
        // 函数式接口中被实现方法的第一个参数作为调用者
        // 后面的参数全部传给该方法作为参数
        MyTest mt = String::substring;
        String str = mt.test("Java I Love you", 2, 8);
        System.out.println(str);

        // 4. 引用构造器
        // 下面代码使用Lambda表达式创建YourTest对象
        // YourTest yt = a -> new JFrame(a);
        // JFrame jf = yt.win("我的窗口");
        // System.out.println(jf);
        // 构造器引用代替Lambda表达式
        // 函数式接口中被实现方法的全部参数传给该构造器作为参数
        YourTest yt = JFrame::new;
        JFrame jf = yt.win("你的窗口");
        System.out.println(jf);
    }
}
