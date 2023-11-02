package org.example.ch14_annotation.sec_01_basic_annotation;

import java.util.Arrays;

public class E_ErrorUtilsTest {
    public static void main(String[] args) {
        D_ErrorUtils.faultyMethod(Arrays.asList("Hello!"), Arrays.asList("World!"));
    }
}
