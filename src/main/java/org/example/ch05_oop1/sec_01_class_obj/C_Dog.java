package org.example.ch05_oop1.sec_01_class_obj;

public class C_Dog {
    // 定义一个jump()方法
    public void jump() {
        System.out.println("正在执行jump方法");
    }

    // 定义一个run()方法，run()方法需要借助jump()方法
    public void run() {
//        var d = new C_Dog();
//        d.jump();
        // 使用this引用调用run()方法的对象
        // this.jump();
        // 大部分时候，一个方法访问该类中定义的其它方法，成员变量时加不加this前缀的效果完全一样
        jump();
        System.out.println("正在执行run方法");
    }
}
