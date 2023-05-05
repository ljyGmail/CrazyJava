package org.example.ch06_oop2.sec_06_java9_improved_interface;

public class J_PrintCommd implements H_Command {
    @Override
    public void process(int element) {
        System.out.println("迭代输出目标数组的元素: " + element);
    }
}
