package org.example.ch05_oop1.sec_06_inheritance;

class Creature {
    public Creature() {
        System.out.println("Create无参数的构造器");
    }
}

class Animal extends Creature {
    public Animal(String name) {
        System.out.println("Animal带一个参数的构造器，该动物的name为" + name);
    }

    public Animal(String name, int age) {
        // 使用this调用同一个重载的构造器
        this(name);
        System.out.println("Animal带两个参数的构造器，其age为" + age);
    }
}

public class H_Wolf extends Animal {
    public H_Wolf() {
        // 显式调用父类有两个参数的构造器
        super("灰太狼", 3);
        System.out.println("Wolf无参数的构造器");
    }

    public static void main(String[] args) {
        new H_Wolf();
    }
}
