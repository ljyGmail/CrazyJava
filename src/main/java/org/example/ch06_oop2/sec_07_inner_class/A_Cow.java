package org.example.ch06_oop2.sec_07_inner_class;

public class A_Cow {
    private double weight;

    // 外部类的两个重载的构造器
    public A_Cow() {
    }

    public A_Cow(double weight) {
        this.weight = weight;
    }

    // 定义一个非静态内部类
    private class CowLeg {
        // 非静态内部类的两个实例变量
        private double length;
        private String color;

        // 非静态内部类的两个重载的构造器
        public CowLeg() {
        }

        public CowLeg(double length, String color) {
            this.length = length;
            this.color = color;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        // 非静态内部类的实例方法
        public void info() {
            System.out.println("当前牛腿的颜色: " + color + ", 高: " + length);
            // 直接访问外部类的private修饰的成员变量
            System.out.println("本牛腿所在奶牛重: " + weight);
        }
    }

    public void test() {
        var c1 = new CowLeg(1.12, "黑白相间");
        c1.info();
    }

    public static void main(String[] args) {
        var cow = new A_Cow(378.9);
        cow.test();
    }
}
