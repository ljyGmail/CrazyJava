package org.example.ch14_annotation.sec_02_jdk_meta_annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
// 定义Testable注解将被javadoc工具提取
@Documented
public @interface A_Testable {
}
