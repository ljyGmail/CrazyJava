package org.example.ch09_generics.sec_02_generics_going_deeper;

public class A_Apple<T> {
    // 使用T类型定义实例变量
    private T info;

    public A_Apple() {
    }

    // 下面方法中使用T类型来定义构造器
    public A_Apple(T info) {
        this.info = info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return this.info;
    }

    public static void main(String[] args) {
        // 由于传给T形参的是String，所以构造器参数只能是String
        A_Apple<String> a1 = new A_Apple<>("苹果");
        System.out.println(a1.getInfo());
        // 由于传给T形参的是Double，所以构造器参数只能是Double或double
        A_Apple<Double> a2 = new A_Apple<>(5.67);
        System.out.println(a2.getInfo());
    }
}
