package org.example.ch06_oop2.sec_09_enum;

public enum K_Operation {

    PLUS {
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES {
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };

    // 为枚举类定义一个抽象方法
    // 这个抽象方法由不同的枚举值提供不同的实现
    public abstract double eval(double x, double y);

    public static void main(String[] args) {
        System.out.println(K_Operation.PLUS.eval(3, 4));
        System.out.println(K_Operation.MINUS.eval(5, 4));
        System.out.println(K_Operation.TIMES.eval(5, 4));
        System.out.println(K_Operation.DIVIDE.eval(5, 4));
    }
}
