package org.example.ch18_reflection.sec_01_class_loading_link_initialization;

class MyTest {
    static {
        System.out.println("静态初始化块...");
    }

    // 使用一个字符串直接量为static final的类变量赋值
    static final String compileConstant = "疯狂Java讲义";
    // 采用系统当前事件为static final类变量赋值
    static final String runtimeConstant = System.currentTimeMillis() + "";
}

public class E_CompileConstantTest {
    public static void main(String[] args) {
        // 访问、输出MyTest中的compileConstant类变量
        System.out.println(MyTest.compileConstant);
        System.out.println(MyTest.runtimeConstant);
    }
}
