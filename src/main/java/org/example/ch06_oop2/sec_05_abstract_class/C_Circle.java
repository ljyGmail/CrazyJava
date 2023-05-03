package org.example.ch06_oop2.sec_05_abstract_class;

public class C_Circle extends A_Shape {
    private double radius;

    public C_Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 重写Shape类的计算周长的抽象方法
    @Override
    public double calPerimeter() {
        return 2 * Math.PI * radius;
    }

    // 重写Shape类的返回形状的抽象方法
    @Override
    public String getType() {
        return getColor() + "圆形";
    }

    public static void main(String[] args) {
        A_Shape s1 = new B_Triangle("黑色", 3, 4, 5);
        A_Shape s2 = new C_Circle("黄色", 3);
        System.out.println(s1.getType());
        System.out.println(s1.calPerimeter());
        System.out.println(s2.getType());
        System.out.println(s2.calPerimeter());
    }
}
