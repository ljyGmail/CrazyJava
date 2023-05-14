package org.example.ch07_basic_api.sec_03_common_classes;

import java.util.Objects;

public class B_ObjectsTest {
    // 定义一个obj变量，她得默认值是null
    static B_ObjectsTest obj;
    public static void main(String[] args) {
        // 输出一个null对象的hashCode值，输出0
        System.out.println(Objects.hashCode(obj));
        // 输出一个null对象的toString,输出null
        System.out.println(Objects.toString(obj));
        // 要求obj不能为null，如果obj为null则引发异常
        // obj = new B_ObjectsTest();
        System.out.println(Objects.requireNonNull(obj, "obj参数不能是null!"));
    }
}
