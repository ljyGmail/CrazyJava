package org.example.ch05_oop1.sec_06_inheritance;

public class D_Ostrich extends C_Bird{
    @Override
    public void fly() {
        System.out.println("我只能在地上奔跑...");
    }

    public static void main(String[] args) {
        // 创建Ostrich对象
        var os=new D_Ostrich();
        // 执行Ostrich对象的fly()方法，将输出"我只能在地上奔跑..."
        os.fly();
    }
}
