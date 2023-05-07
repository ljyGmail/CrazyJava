package org.example.ch06_oop2.sec_08_java11_improved_lambda;

public class D_VarInLambda {
    public static void main(String[] args) {
        // 使用Lambda表达式对var变量赋值
        // 必须显式指定Lambda表达式的目标类型
        var run = (Runnable) () -> {
            for (var i = 0; i < 100; i++) {
                System.out.println();
            }
        };
    }
}
