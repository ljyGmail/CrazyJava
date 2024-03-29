package org.example.ch16_multi_threading.sec_08_thread_pool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

// 继承RecursiveAction来实现"可分解"的任务
class PrintTask extends RecursiveAction {
    // 每个"小任务"最多只打印50个数
    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    // 打印从start到end的任务
    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // 当end与start之间的差小于THRESHOLD时，开始打印
        if (end - start < THRESHOLD) {
            for (var i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值: " + i);
            }
        } else {
            // 当end与start之间的差大于THRESHOLD，即要打印的数超过50个小时
            // 将大任务分解成两个"小任务"
            int middle = (start + end) / 2;
            var left = new PrintTask(start, middle);
            var right = new PrintTask(middle, end);
            // 并行执行两个"小任务"
            left.fork();
            right.fork();
        }
    }
}

public class B_ForkJoinPoolTest {
    public static void main(String[] args) throws Exception {
        var pool = new ForkJoinPool();
        // 提交可分解的PrintTask任务
        pool.submit(new PrintTask(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        // 关闭线程池
        pool.shutdown();
    }
}
