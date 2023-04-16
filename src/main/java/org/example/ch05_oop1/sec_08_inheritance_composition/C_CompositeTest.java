package org.example.ch05_oop1.sec_08_inheritance_composition;

class AnimalComposite {
    private void beat() {
        System.out.println("心脏跳动...");
    }

    public void breathe() {
        beat();
        System.out.println("吸一口气，吐一口气，呼吸中...");
    }
}

class BirdComposite {
    // 将原来的父类组合到原来的子类，作为子类的一个组合成分
    private AnimalComposite a;

    public BirdComposite(AnimalComposite a) {
        this.a = a;
    }

    // 重新定义一个自己的breathe()方法
    public void breathe() {
        // 直接复用AnimalComposite提供的breathe()方法来实现BirdComposite的breathe()方法
        a.breathe();
    }

    public void fly() {
        System.out.println("我在天空自在地飞翔...");
    }
}

class WolfComposite {
    // 将原来的父类组合到原来的子类，作为子类的一个组合成分
    private AnimalComposite a;

    public WolfComposite(AnimalComposite a) {
        this.a = a;
    }

    // 重新定义一个自己的breathe()方法
    public void breathe() {
        // 直接复用AnimalComposite提供的breathe()方法来实现WolfComposite的Breathe()方法
        a.breathe();
    }

    public void run() {
        System.out.println("我在陆地上快速奔跑...");
    }
}

public class C_CompositeTest {
    public static void main(String[] args) {
        // 此时需要显式创建被组合的对象
        var a1 = new AnimalComposite();
        var b = new BirdComposite(a1);
        b.breathe();
        b.fly();
        // 此时需要显式创建被组合的对象
        var a2 = new AnimalComposite();
        var w = new WolfComposite(a2);
        w.breathe();
        w.run();
    }
}
