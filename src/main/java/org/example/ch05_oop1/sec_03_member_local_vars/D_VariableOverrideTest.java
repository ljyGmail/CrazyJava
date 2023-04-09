package org.example.ch05_oop1.sec_03_member_local_vars;

public class D_VariableOverrideTest {
    // 定义一个name实例变量
    private String name = "李刚";
    // 定义一个price类变量
    private static double price = 78.0;

    // 主方法，程序的入口
    public static void main(String[] args) {
        // 方法里的局部变量，局部变量覆盖成员变量
        var price = 65;
        // 直接访问price变量，将输出price局部变量的值：65
        System.out.println(price);
        // 使用类名作为price变量的限定,将输出price类变量的值：78.0
        System.out.println(D_VariableOverrideTest.price);
        // 运行info方法
        new D_VariableOverrideTest().info();
    }

    public void info() {
        // 方法里的局部变量，局部变量覆盖成员变量
        var name = "孙悟空";
        // 直接访问name变量，将输出name局部变量的值: "孙悟空"
        System.out.println(name);
        // 使用this来作为name变量的限定，将输出name实例变量的值："李刚"
        System.out.println(this.name);
    }
}
