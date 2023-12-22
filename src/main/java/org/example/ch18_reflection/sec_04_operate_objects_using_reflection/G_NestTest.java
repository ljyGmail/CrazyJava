package org.example.ch18_reflection.sec_04_operate_objects_using_reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class G_NestTest {
    public class InA {
        // 内部类的两个private成员
        private int age = 2;

        private void foo() {
            System.out.println("private的foo方法");
        }
    }

    public class InB {
        // 内部类的两个private成员
        private String name = "疯狂Java";

        private void bar() throws Exception {
            InA a = new InA();
            // 访问另外一个内部类的private成员，完全没问题
            a.age = 20;
            System.out.println(a.age);
            a.foo();
            System.out.println("private的bar方法");
            // 通过反射访问另外一个内部类的private成员
            // 在Java 11之前报错，在Java 11之后没有问题
            Field f = InA.class.getDeclaredField("age");
            f.set(a, 29);
            System.out.println(f.get(a));
            Method m = InA.class.getDeclaredMethod("foo");
            m.invoke(a);

            // 获取NestTest的嵌套属主类，由于它自身就是外部类，因此返回它自身(NestTest)
            System.out.println(G_NestTest.class.getNestHost());
            // 获取NestTest.InA的嵌套属主类，返回NestTest类
            System.out.println(Class.forName("org.example.ch18_reflection.sec_04_operate_objects_using_reflection.G_NestTest$InA").getNestHost());
            // 获取NestTest的所有嵌套成员，将会看到NestTest、InA、InB三个嵌套成员
            System.out.println(Arrays.toString(G_NestTest.class.getNestMembers()));
            // 获取NestTest.InA是否为NestTest.InB的嵌套同伴，返回true
            System.out.println(Class.forName("org.example.ch18_reflection.sec_04_operate_objects_using_reflection.G_NestTest$InA")
                    .isNestmateOf(Class.forName("org.example.ch18_reflection.sec_04_operate_objects_using_reflection.G_NestTest$InB")));
        }
    }

    public void info() throws Exception {
        InB b = new InB();
        // 外部类访问内部类的private成员，完全没问题
        b.name = "crazyit.org";
        System.out.println(b.name);
        b.bar();
        // 外部类通过反射访问内部类的private成员
        // 在Java 11之前报错，在Java 11之后没有问题
        Field f = InB.class.getDeclaredField("name");
        f.set(b, "fkjava.org");
        System.out.println(f.get(b));
        Method m = InB.class.getDeclaredMethod("bar");
        m.invoke(b);
    }

    public static void main(String[] args) throws Exception {
        new G_NestTest().info();
    }
}
