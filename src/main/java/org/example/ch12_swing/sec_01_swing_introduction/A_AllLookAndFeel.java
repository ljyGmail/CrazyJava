package org.example.ch12_swing.sec_01_swing_introduction;

import javax.swing.*;

public class A_AllLookAndFeel {
    public static void main(String[] args) {
        System.out.println("当前系统可用的所有LAF:");
        for (var info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + "--->" + info);
        }
    }
}
