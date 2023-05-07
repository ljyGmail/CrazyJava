package org.example.ch06_oop2.sec_06_java9_improved_interface;

import java.awt.print.Printable;

// 定义一个Product接口
interface Product {
    int getProduceTime();
}

// 让Printer类实现Output和Product接口
public class D_Printer implements A_Output, Product {
    private String[] printData = new String[MAX_CACHE_LINE];

    // 用以记录当前需打印的作业数
    private int dataNum;

    @Override
    public void out() {
        // 只要还有作业，就继续打印
        while (dataNum > 0) {
            System.out.println("打印机打印: " + printData[0]);
            // 把作业队列整体前移一位，并将剩下的作业数减1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE) {
            System.out.println("输出队列已满，添加失败");
        } else {
            // 把打印数据添加到队列里，已保存数据的数量加1
            printData[dataNum++] = msg;
        }
    }

    @Override
    public int getProduceTime() {
        return 45;
    }

    public static void main(String[] args) {
        // 创建一个Printer对象，当成Output使用
        A_Output o = new D_Printer();
        o.getData("轻量级Java EE企业应用实战");
        o.getData("疯狂Java讲义");
        o.out();
        o.getData("疯狂Android讲义");
        o.getData("疯狂Ajax讲义");
        o.out();
        // 调用Output接口中定义的默认方法
        o.print("孙悟空", "猪八戒", "白骨精");
        o.test();
        // 创建一个Print对象，当成Product使用
        Product p = new D_Printer();
        System.out.println(p.getProduceTime());
        // 所以接口类型的引用变量都可以直接赋给Object类型的变量
        Object obj = p;
    }
}