package org.example.ch05_oop1.sec_03_member_local_vars;

public class G_ScopeTest3 {
    public static void main(String[] args) {
        // 定义一个代码局部变量作为循环变量
        for (var i = 0; i < 10; i++) {
            System.out.println("Hello");
        }
    }
}
