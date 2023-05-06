package org.example.ch06_oop2.sec_07_inner_class;

interface Product {
    double getPrice();

    String getName();
}

public class L_AnonymousTest {
    public void test(Product p) {
        System.out.println("购买了一个" + p.getName() + ", 花掉了" + p.getPrice());
    }

    public static void main(String[] args) {
        var ta = new L_AnonymousTest();
        // 调用test()方法时，需要传入一个Product参数
        // 此处传入其匿名实现类的实例
        ta.test(new Product() {
            @Override
            public double getPrice() {
                return 567.8;
            }

            @Override
            public String getName() {
                return "AGP显卡";
            }
        });
    }
}
