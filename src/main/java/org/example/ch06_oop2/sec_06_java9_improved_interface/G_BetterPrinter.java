package org.example.ch06_oop2.sec_06_java9_improved_interface;

public class G_BetterPrinter implements A_Output {
    private String[] printData = new String[MAX_CACHE_LINE * 2];

    // 用以记录当前需打印的作业数
    private int dataNum = 0;

    @Override
    public void out() {
        // 只要还有作业，就继续打印
        while (dataNum > 0) {
            System.out.println("高速打印机正在打印: " + printData[0]);
            // 把作业队列整体前移一位，并将剩下的作业数减1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE * 2) {
            System.out.println("输出队列已满，添加失败");
        } else {
            // 把打印数据添加到队列里，已保存数据的数量加1
            printData[dataNum++] = msg;
        }
    }
}
