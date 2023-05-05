package org.example.ch06_oop2.sec_06_java9_improved_interface;

public class I_ProcessArray {
    public void process(int[] target, H_Command cmd) {
        for (var t : target) {
            cmd.process(t);
        }
    }
}
