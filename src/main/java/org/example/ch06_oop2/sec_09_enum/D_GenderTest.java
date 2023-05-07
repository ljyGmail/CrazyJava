package org.example.ch06_oop2.sec_09_enum;

public class D_GenderTest {
    public static void main(String[] args) {
        // 通过Enum的valueOf()方法来获取指定枚举类的枚举值
        C_Gender g = Enum.valueOf(C_Gender.class, "FEMALE");
        // 直接为枚举值的name实例变量赋值
        g.name = "女";
        // 直接访问枚举值的name实例变量
        System.out.println(g + "代表: " + g.name);
    }
}
