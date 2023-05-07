package org.example.ch06_oop2.sec_08_java11_improved_lambda;

import org.example.ch06_oop2.sec_06_java9_improved_interface.H_Command;
import org.example.ch06_oop2.sec_06_java9_improved_interface.I_ProcessArray;

public class A_CommandTest {
    public static void main(String[] args) {
        var pa = new I_ProcessArray();
        int[] target = {3, -4, 6, 4};
        // 处理数组，具体处理行为取决于匿名内部类
        pa.process(target, new H_Command() {
            @Override
            public void process(int element) {
                System.out.println("数组元素的平方是: " + element * element);
            }
        });
    }
}
