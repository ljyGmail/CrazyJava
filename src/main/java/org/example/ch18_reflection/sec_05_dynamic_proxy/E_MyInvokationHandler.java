package org.example.ch18_reflection.sec_05_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class E_MyInvokationHandler implements InvocationHandler {
    // 需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 执行动态代理对象的所有方法时，都会被替换成如下的invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        var du = new C_DogUtil();
        // 执行DogUtil对象中的method1方法
        du.method1();
        // 以target作为主调来执行method()方法
        Object result = method.invoke(target, args);
        // 执行DogUtil对象中的method2方法
        du.method2();
        return result;
    }
}
