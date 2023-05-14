package org.example.ch07_basic_api.sec_03_common_classes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class I_Arith {
    // 默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    // 构造器私有，让这个类不能实例化
    private I_Arith() {
    }

    // 提供精确的加法运算
    public static double add(double v1, double v2) {
        var b1 = BigDecimal.valueOf(v1);
        var b2 = BigDecimal.valueOf(v2);
        return b1.add(b2).doubleValue();
    }

    // 提供精确的减法运算
    public static double sub(double v1, double v2) {
        var b1 = BigDecimal.valueOf(v1);
        var b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }

    // 提供精确的乘法运算
    public static double mul(double v1, double v2) {
        var b1 = BigDecimal.valueOf(v1);
        var b2 = BigDecimal.valueOf(v2);
        return b1.multiply(b2).doubleValue();
    }

    // 提供(相对)精确的乘法运算，当发生除不尽的情况
    // 精确到小数点以后10位的数字四舍五入
    public static double div(double v1, double v2) {
        var b1 = BigDecimal.valueOf(v1);
        var b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, DEF_DIV_SCALE, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(I_Arith.add(0.05, 0.01));
        System.out.println("0.05 + 0.01 = " + I_Arith.add(0.05, 0.01));
        System.out.println("1.0 - 0.42 = " + I_Arith.sub(1.0, 0.42));
        System.out.println("4.015 * 100 = " + I_Arith.mul(4.015, 100));
        System.out.println("123.3 / 100 = " + I_Arith.div(123.3, 100));
    }
}
