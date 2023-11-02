package org.example.ch14_annotation.sec_04_apt;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface A_Persistent {
    String table();
}
