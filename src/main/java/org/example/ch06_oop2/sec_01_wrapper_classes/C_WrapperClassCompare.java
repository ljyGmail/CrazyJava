package org.example.ch06_oop2.sec_01_wrapper_classes;

public class C_WrapperClassCompare {
    public static void main(String[] args) {
        var a = Integer.valueOf(6);
        // 输出true
        System.out.println("6的包装类实例是否大于5.0: " + (a > 5.0));

        // 输出true
        System.out.println("比较2个包装类的实例是否相等: " + (Integer.valueOf(2) == Integer.valueOf(2)));

        // 通过自动装箱，允许把基本类型值赋值给包装类实例
        Integer ina = 2;
        Integer inb = 2;
        // 输出true
        System.out.println("两个2自动装箱后是否相等: " + (ina == inb));

        Integer biga = 128;
        Integer bigb = 128;
        // 输出false
        System.out.println("两个128自动装箱后是否相等: " + (biga == bigb));

        System.out.println(Boolean.compare(true, false)); // 输出1
        System.out.println(Boolean.compare(true, true)); // 输出0
        System.out.println(Boolean.compare(false, true)); // 输出-1
    }
}
