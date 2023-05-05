package org.example.ch06_oop2.sec_06_java9_improved_interface;

public class L_CommandTest {
    public static void main(String[] args) {
        var pa = new I_ProcessArray();
        int[] target = {3, -4, 6, 4};
        // 第一次处理数组，具体处理行为取决于PrintCommand
        pa.process(target, new J_PrintCommd());
        System.out.println("====================");
        // 第二次处理数组，具体处理行为取决于SquareCommand
        pa.process(target, new K_SquareCommand());
    }
}
