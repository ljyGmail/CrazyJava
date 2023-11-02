package org.example.ch14_annotation.sec_03_customized_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 指定该注解信息会保留到运行时
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface I_FkTags {
    // 定义value成员变量，该成员变量可接受多个@FkTag注解
    H_FkTag[] value();
}
