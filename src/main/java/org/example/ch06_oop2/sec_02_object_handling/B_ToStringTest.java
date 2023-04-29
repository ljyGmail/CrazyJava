package org.example.ch06_oop2.sec_02_object_handling;

class Apple {
    private String color;
    private double weight;

    public Apple() {
    }

    // 提供有参数的构造器
    public Apple(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
//        return "一个苹果，颜色是: " + color + ", 重量是: " + weight;
        return "Apple[color=" + color + ", weight=" + weight + "]";
    }
}

public class B_ToStringTest {
    public static void main(String[] args) {
        var a = new Apple("红色", 5.68);
        // 打印Apple对象
        System.out.println(a);
    }
}
