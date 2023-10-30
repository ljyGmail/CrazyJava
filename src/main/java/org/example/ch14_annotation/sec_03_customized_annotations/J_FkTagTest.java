package org.example.ch14_annotation.sec_03_customized_annotations;

@H_FkTag(age = 5)
@H_FkTag(name = "疯狂Java", age = 9)
public class J_FkTagTest {
    public static void main(String[] args) {
        Class<J_FkTagTest> clazz = J_FkTagTest.class;
        /* 使用Java 8新增的getDeclaredAnnotationsByType()方法获取
            修饰FkTagTest类的多个@FkTag注解 */
        H_FkTag[] tags = clazz.getDeclaredAnnotationsByType(H_FkTag.class);
        // 遍历修饰FkTagTest类的多个@FkTag注解
        for (var tag : tags) {
            System.out.println(tag.name() + "-->" + tag.age());
        }
        /* 使用传统的getDeclaredAnnotation()方法获取
            修饰FkTagTest类的@FkTags注解 */
        I_FkTags container = clazz.getDeclaredAnnotation(I_FkTags.class);
        System.out.println(container);
    }
}
