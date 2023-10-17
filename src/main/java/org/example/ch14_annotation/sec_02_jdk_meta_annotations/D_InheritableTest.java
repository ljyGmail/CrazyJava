package org.example.ch14_annotation.sec_02_jdk_meta_annotations;

// 使用@Inheritable修饰的Base类
@C_Inheritable
class Base {

}

// InheritableTest类只是继承了Base类
// 并未直接使用@InherableTest注解修饰
public class D_InheritableTest extends Base {
    public static void main(String[] args) {
        // 打印D_IneritableTest类是否有@Inheritable修饰
        System.out.println(D_InheritableTest.class.isAnnotationPresent(C_Inheritable.class));
    }
}
