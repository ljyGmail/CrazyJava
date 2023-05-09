package org.example.ch07_basic_api.sec_01_user_interactivity;

public class A_ArgsTest {
    public static void main(String[] args) {
        // 输出args数组的长度
        System.out.println(args.length);
        // 遍历args数组的每个元素
        for (var arg : args) {
            System.out.println(arg);
        }
    }
}
