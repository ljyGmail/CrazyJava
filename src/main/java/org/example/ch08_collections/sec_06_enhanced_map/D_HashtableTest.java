package org.example.ch08_collections.sec_06_enhanced_map;

import java.util.Hashtable;

class A {
    int count;

    public A(int count) {
        this.count = count;
    }

    // 根据count的值来判断两个对象是否相等
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj != null && obj.getClass() == A.class) {
            var a = (A) obj;
            return this.count == a.count;
        }
        return false;
    }

    // 根据count来计算hashCode值

    @Override
    public int hashCode() {
        return this.count;
    }
}

class B {
    // 重写equals()方法，B对象与任何对象通过equals()方法比较都返回true

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class D_HashtableTest {
    public static void main(String[] args) {
        var ht = new Hashtable();
        ht.put(new A(60000), "疯狂Java讲义");
        ht.put(new A(87563), "轻量级Java EE企业应用实战");
        ht.put(new A(1232), new B());
        System.out.println(ht);
        // 只要两个对象通过equals()方法比较返回true
        // Hashtable就认为它们是相等的value
        // 由于Hashtable中有一个B对象
        // 它与任何对象通过equals()方法比较都相等，所以下面输出true
        System.out.println(ht.containsValue("测试字符串")); // 输出true
        // 只要两个A对象的count相等，它们通过equals()方法比较返回true，且hashCode值相等
        // Hashtable即认为它们是相同的key，所以下面输出true
        System.out.println(ht.containsKey(new A(87563))); // 输出true
        // 下面语句可以删除最后一个key-value对
        ht.remove(new A(1232));
        System.out.println(ht);
    }
}
