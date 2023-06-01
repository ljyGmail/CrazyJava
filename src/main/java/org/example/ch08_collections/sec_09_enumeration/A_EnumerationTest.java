package org.example.ch08_collections.sec_09_enumeration;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class A_EnumerationTest {
    public static void main(String[] args) {
        var v = new Vector();
        v.add("疯狂Java讲义");
        v.add("轻量级Java EE企业应用实战");
        var scores = new Hashtable();
        scores.put("语文", 78);
        scores.put("数学", 88);
        Enumeration em = v.elements();
        while (em.hasMoreElements()) {
            System.out.println(em.nextElement());
        }

        Enumeration keyEm = scores.keys();
        while (keyEm.hasMoreElements()) {
            Object key = keyEm.nextElement();
            System.out.println(key + "--->" + scores.get(key));
        }
    }
}
