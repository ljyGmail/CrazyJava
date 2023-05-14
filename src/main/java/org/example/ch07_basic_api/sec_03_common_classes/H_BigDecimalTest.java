package org.example.ch07_basic_api.sec_03_common_classes;

import java.math.BigDecimal;

public class H_BigDecimalTest {
    public static void main(String[] args) {
        var f1 = new BigDecimal("0.05");
        var f2 = BigDecimal.valueOf(0.01);
        var f3 = new BigDecimal(0.05);
        System.out.println("使用String作为BigDecimal构造器参数: ");
        System.out.println("0.05 + 0.01 = " + f1.add(f2));
        System.out.println("0.05 - 0.01 = " + f1.subtract(f2));
        System.out.println("0.05 * 0.01 = " + f1.multiply(f2));
        System.out.println("0.05 / 0.01 = " + f1.divide(f2));
        System.out.println("使用Double作为BigDecimal构造器参数: ");
        System.out.println("0.05 + 0.01 = " + f3.add(f2));
        System.out.println("0.05 - 0.01 = " + f3.subtract(f2));
        System.out.println("0.05 * 0.01 = " + f3.multiply(f2));
        System.out.println("0.05 / 0.01 = " + f3.divide(f2));
    }
}
