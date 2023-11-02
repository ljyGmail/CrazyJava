package org.example.ch14_annotation.sec_04_apt;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface C_Property {
    String column();
    String type();
}
