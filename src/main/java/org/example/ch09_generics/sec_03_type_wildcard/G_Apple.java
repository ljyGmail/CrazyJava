package org.example.ch09_generics.sec_03_type_wildcard;

import org.example.ch05_oop1.sec_04_encapsulation.lee.sub.Apple;

import java.io.Serializable;

public class G_Apple<T extends Number & Serializable> {
    T col;

    public static void main(String[] args) {
        G_Apple<Integer> ai = new G_Apple<>();
        G_Apple<Double> ad = new G_Apple<>();
        // 下面代码将引发编译异常，下面代码试图把String类型传给T形参
        // 但String不是Number的子类型，所以引起编译错误
        // G_Apple<String> as = new Apple<>();
    }
}
