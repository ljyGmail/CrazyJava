package org.example.ch18_reflection.sec_05_dynamic_proxy;

public class G_Test {
    public static void main(String[] args) throws Exception {
        // 创建一个原始的GunDog，作为target
        B_Dog target = new D_GunDog();
        // 以指定的target来创建动态代理对象
        var dog = (B_Dog) F_MyProxyFactory.getProxy(target);
        dog.info();
        dog.run();
    }
}
