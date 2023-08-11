package org.example.ch09_generics.sec_03_type_wildcard;

// 定义Shape的子类Rectangle
public class D_Rectangle extends B_Shape {

    // 实现画图方法，以打印字符串来模拟画图方法实现
    @Override
    public void draw(E_Canvas c) {
        System.out.println("把一个矩形画在画布" + c + "上");
    }
}
