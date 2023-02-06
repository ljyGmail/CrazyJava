package org.example.ch08_collections.sec_03_set;

import java.util.TreeSet;

class S implements Comparable {
    int count;

    public S(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "S[count" + count + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == S.class) {
            var r = (S) obj;
            return this.count == r.count;
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        var s = (S) o;
        return count > s.count ? 1 : count < s.count ? -1 : 0;
    }
}

public class H_TreeSetTest3 {
    public static void main(String[] args) {
        var ts = new TreeSet();
        ts.add(new S(5));
        ts.add(new S(-3));
        ts.add(new S(9));
        ts.add(new S(-2));
        // 打印TreeSet集合，集合元素是有序排列的
        System.out.println(ts);
        // 取出第一个元素
        var first = (S) ts.first();
        // 对第一个元素的count复制
        first.count = 20;
        // 取出最后一个元素
        var last = (S) ts.last();
        // 对最后一个元素的count赋值，与第二个元素的count相同
        last.count = -2;
        // 再次输出将看到TreeSet里的元素处于无序状态，且有重复元素
        System.out.println(ts);
        // 输出实例变量被改变的元素，输出失败
        System.out.println(ts.remove(new S(-2)));
        System.out.println(ts);
        // 输出实例变量没有被改变的元素，输出成功
        System.out.println(ts.remove(new S(5)));
        System.out.println(ts);
    }
}
