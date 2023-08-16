package org.example.ch10_exception_handling.sec_02_exception_handling_mechanism;

public class F_FinallyFlowTest {
    public static void main(String[] args) {
        boolean a = test();
        System.out.println(a);
    }

    public static boolean test() {
        try {
            // 因为finally块中包含了return语句
            // 所以下面的return语句失去作用
            return true;
        } finally {
            return false;
        }
    }
}
