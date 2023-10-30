package org.example.ch14_annotation.sec_02_jdk_meta_annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface C_Inheritable {
}
