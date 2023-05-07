package org.example.ch06_oop2.sec_09_enum;

public class F_GenderTest {
    public static void main(String[] args) {
        E_Gender g = E_Gender.valueOf("FEMALE");
        g.setName("女");
        System.out.println(g + "代表: " + g.getName());
        // 此时设置name值时将会提示参数错误
        g.setName("男");
        System.out.println(g + "代表: " + g.getName());
    }
}
