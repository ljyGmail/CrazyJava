package org.example.ch14_annotation.sec_03_customized_annotations;

public class B_MyTest {

    // 使用@Testable注解指定该方法时可测试的
    @A_Testable
    public static void m1() {

    }

    public static void m2() {

    }

    // 使用@Testable注解指定该方法时可测试的
    @A_Testable
    public static void m3() {
        throw new IllegalArgumentException("参数出错了!");
    }

    public static void m4() {

    }

    // 使用@Testable注解指定该方法时可测试的
    @A_Testable
    public static void m5() {
    }

    public static void m6() {

    }

    // 使用@Testable注解指定该方法时可测试的
    @A_Testable
    public static void m7() {
        throw new RuntimeException("程序业务出现异常!");
    }

    public static void m8() {

    }
}
