package org.example.ch08_collections.sec_03_set;

import java.util.HashSet;

class R {
    int count;

    public R(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "R[count" + count + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == R.class) {
            var r = (R) obj;
            return this.count == r.count;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.count;
    }
}

public class B_HashSetTest2 {
    public static void main(String[] args) {
        var hs = new HashSet();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));
        // 打印HashSet集合，集合元素没有重复
        System.out.println(hs);
        // 取出第一个元素
        var it = hs.iterator();
        var first = (R) it.next();
        // 为第一个元素的count实例变量赋值
        first.count = -3;
        // 再次输出HashSet集合，集合元素没有重复元素
        System.out.println(hs);
        hs.remove(new R(-3));
        // 可以看到被删除了一个R元素
        System.out.println(hs);
        System.out.println("hs是否包含count为-3的R对象? " + hs.contains(new R(-3))); // false
        System.out.println("hs是否包含count为-2的R对象? " + hs.contains(new R(-2))); // false
        // 可见把可变对象添加到HashSet之后，不要再去修改该集合元素中参与计算hashCode()，equals()的实例变量
        // 否则将导致HashSet无法正确操作这些集合元素
    }
}