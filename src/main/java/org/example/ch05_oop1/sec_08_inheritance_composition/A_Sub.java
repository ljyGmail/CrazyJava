package org.example.ch05_oop1.sec_08_inheritance_composition;

class Base {
    public Base() {
        test();
    }

    public void test() {
        System.out.println("将被子类重写的方法");
    }
}

public class A_Sub extends Base {
    private String name;

    public void test() {
        System.out.println("子类重写父类的方法，其name字符串长度: " + name.length());
    }

    public static void main(String[] args) {
        // 下面代码将会引发空指针异常
        var s = new A_Sub();
    }
}
