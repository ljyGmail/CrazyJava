package org.example.ch06_oop2.sec_10_gc;

import java.lang.ref.WeakReference;

public class D_ReferenceTest {
    public static void main(String[] args) throws Exception {
        // 创建一个字符串对象
        var str = new String("疯狂Java讲义");
        // var str = "疯狂Java讲义" // 使用此代码将看不到效果，因为系统不会回收常量池里的字符串直接量
        // 创建一个弱引用，让此弱引用引用到"疯狂Java讲义"字符串
        var wr = new WeakReference(str);
        // 切断str引用和"疯狂Java讲义"字符串之间的引用
        str = null;
        // 取出弱引用所引用的对象
        System.out.println(wr.get());
        // 轻质垃圾回收
        System.gc();
        System.runFinalization();
        // 再次取出弱引用所引用的对象
        System.out.println(wr.get());
    }
}
