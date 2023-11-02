package org.example.ch14_annotation.sec_04_apt;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface B_Id {
    String column();
    String type();
    String generator();
}
