package org.example.ch06_oop2.sec_06_java9_improved_interface;

public class E_Computer {
    private A_Output output;

    public E_Computer(A_Output output) {
        this.output = output;
    }

    // 定义一个模拟获取字符串输入的方法
    public void keyIn(String msg) {
        output.getData(msg);
    }

    // 定义一个模拟打印的方法
    public void print() {
        output.out();
    }
}
