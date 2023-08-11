package org.example.ch09_generics.sec_03_type_wildcard;

import java.util.Comparator;
import java.util.TreeSet;

public class F_TreeSetTest {
    public static void main(String[] args) {
        // Comparator的实际类型是TreeSet的元素类型的父类，满足要求
        TreeSet<String> ts1 = new TreeSet<>(
                new Comparator<Object>() {

                    @Override
                    public int compare(Object fst, Object snd) {
                        return hashCode() > snd.hashCode() ? 1 : hashCode() < snd.hashCode() ? -1 : 0;
                    }
                }
        );
        ts1.add("hello");
        ts1.add("wa");
        // Comparator的实际类型是TreeSet元素的类型，满足要求
        TreeSet<String> ts2 = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String first, String second) {
                        return first.length() > second.length() ? -1 : first.length() < second.length() ? 1 : 0;
                    }
                }
        );
        ts2.add("hello");
        ts2.add("wa");
        System.out.println(ts1);
        System.out.println(ts2);
    }
}
