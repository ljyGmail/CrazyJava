package org.example.ch05_oop1.sec_05_constructor;

public class A_ConstructorTest {
    public String name;
    public int count;

    // 提供自定义的构造器，该构造器包含两个参数
    public A_ConstructorTest(String name, int count) {
        // 构造器里的this代表它进行初始化的对象
        // 下面两行代码将传入的2个参数赋给this代表对象的name和count实例变量
        this.name = name;
        this.count = count;
    }

    public static void main(String[] args) {
        // 使用自定义的构造器来创建对象
        // 系统将会对该对象执行自定义的初始化
        var tc = new A_ConstructorTest("疯狂Java讲义", 90000);
        // 输出ContructorTest对象的name和count两个实例变量
        System.out.println(tc.name);
        System.out.println(tc.count);
    }
}
