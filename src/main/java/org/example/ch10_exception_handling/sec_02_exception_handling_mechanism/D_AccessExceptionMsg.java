package org.example.ch10_exception_handling.sec_02_exception_handling_mechanism;

import java.io.FileInputStream;
import java.io.IOException;

public class D_AccessExceptionMsg {
    public static void main(String[] args) {
        try {
            var fis = new FileInputStream("a.txt");
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            System.out.println("@@@@@@@@@@@@@@");
            ioe.printStackTrace();
        }
    }
}
