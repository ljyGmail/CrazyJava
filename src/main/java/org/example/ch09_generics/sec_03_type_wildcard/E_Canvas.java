package org.example.ch09_generics.sec_03_type_wildcard;

import java.util.ArrayList;
import java.util.List;

public class E_Canvas {
    // 同时在画布上绘制多个形状
    public void drawAll(List<? extends B_Shape> shapes) {
        for (var s : shapes) {
            s.draw(this);
        }
    }

    public static void main(String[] args) {
        List<C_Circle> circleList = new ArrayList<>();
        var c = new E_Canvas();
        // 不能把List<Circle>当成List<Shape》使用，所以下面代码因此编译错误
        c.drawAll(circleList);
    }
}
