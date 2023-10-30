package org.example.ch14_annotation.sec_03_customized_annotations;

import java.lang.annotation.*;

// 指定该注解信息会保留到运行时
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(I_FkTags.class)
public @interface H_FkTag {
    //  为该注解定义2个成员变量
    String name() default "疯狂软件";

    int age();
}
