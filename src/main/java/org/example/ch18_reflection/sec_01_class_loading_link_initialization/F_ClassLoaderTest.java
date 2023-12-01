package org.example.ch18_reflection.sec_01_class_loading_link_initialization;

class Tester {
    static {
        System.out.println("Tester类的静态初始化块...");
    }
}

public class F_ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        // 下面语句仅仅是加载Tester类
        cl.loadClass("org.example.ch18_reflection.sec_01_class_loading_link_initialization.Tester");
        System.out.println("系统加载Tester类");
        // 下面语句才会初始化Tester类
        Class.forName("org.example.ch18_reflection.sec_01_class_loading_link_initialization.Tester");
    }
}
