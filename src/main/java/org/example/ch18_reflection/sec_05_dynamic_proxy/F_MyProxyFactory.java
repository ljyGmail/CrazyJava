package org.example.ch18_reflection.sec_05_dynamic_proxy;

import java.lang.reflect.Proxy;

public class F_MyProxyFactory {
    // 为指定的target生成动态代理对象
    public static Object getProxy(Object target) throws Exception {
        // 创建一个MyInvokationHandler对象
        E_MyInvokationHandler handler = new E_MyInvokationHandler();
        // 为MyInvokationHandler设置target对象
        handler.setTarget(target);
        // 创建并返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
