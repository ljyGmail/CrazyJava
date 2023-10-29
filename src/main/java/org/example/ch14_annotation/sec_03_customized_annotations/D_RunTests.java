package org.example.ch14_annotation.sec_03_customized_annotations;

public class D_RunTests {
    public static void main(String[] args) throws ClassNotFoundException {
        // 处理MyTest类
        C_ProcessorTest.process("org.example.ch14_annotation.sec_03_customized_annotations.B_MyTest");
    }
}
