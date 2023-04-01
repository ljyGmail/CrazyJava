package org.example.ch05_oop1.sec_01_class_obj;

public class E_StaticAccessNonStatic {
    public void info() {
        System.out.println("简单的info方法");
    }

    public static void main(String[] args) {
        // 因为main()方法是静态方法，而info()是静态方法
        // 调用main()方法的是该类本身，而不是该类的实例
        // 因此省略的this无法指向有效的对象
//        info(); 无法从静态上下文中引用非静态方法 info()

        // 创建一个对象作为调用者来调用info()方法
        new E_StaticAccessNonStatic().info();
    }
}
