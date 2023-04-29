package org.example.ch06_oop2.sec_02_object_handling;

public class C_EqualTest {
    public static void main(String[] args) {
        var it = 65;
        var fl = 65.0f;
        // 将输出true
        System.out.println("65和65.0f是否相等? " + (it == fl));

        var ch = 'A';
        // 将输出true
        System.out.println("65和'A'是否相等? " + (it == ch));

        var str1 = new String("hello");
        var str2 = new String("hello");
        // 将输出false
        System.out.println("str1和str2是否相等? " + (str1 == str2));
        // 将输出true
        System.out.println("str1是否equals str2? " + (str1.equals(str2)));

        // 由于jang.lang.String与C_EqualTest类没有继承关系
        // 所以下面语句导致编译错误
//        System.out.println("hello" == new C_EqualTest());
    }
}
