package org.example.ch06_oop2.sec_06_java9_improved_interface;

public class K_SquareCommand implements H_Command {
    @Override
    public void process(int element) {
        System.out.println("数组元素的平方是: " + element * element);
    }
}
