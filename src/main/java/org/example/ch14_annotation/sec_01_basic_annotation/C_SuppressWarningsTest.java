package org.example.ch14_annotation.sec_01_basic_annotation;

import java.util.ArrayList;
import java.util.List;

// 关闭整个类里的编译器警告
@SuppressWarnings(value = "unchecked")
public class C_SuppressWarningsTest {
    public static void main(String[] args) {
        List<String> myList = new ArrayList();
    }
}
