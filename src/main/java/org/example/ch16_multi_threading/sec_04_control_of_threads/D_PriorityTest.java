package org.example.ch16_multi_threading.sec_04_control_of_threads;

public class D_PriorityTest extends Thread {
    // 定义一个有参数的构造器，用于创建线程时指定name
    public D_PriorityTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (var i = 0; i < 50; i++) {
            System.out.println(getName() + "，其优先级是: " + getPriority() + "，循环变量的值为: " + i);
        }
    }

    public static void main(String[] args) {
        // 改变主线程的优先级
        Thread.currentThread().setPriority(6);
        for (var i = 0; i < 30; i++) {
            if (i == 10) {
                var low = new D_PriorityTest("低级");
                low.start();
                System.out.println("111. 创建之初的优先级: " + low.getPriority());
                // 设置该线程为最低优先级
                low.setPriority(Thread.MIN_PRIORITY);
            }

            if (i == 20) {
                var high = new D_PriorityTest("高级");
                high.start();
                System.out.println("222. 创建之初的优先级: " + high.getPriority());
                // 设置该线程为最高优先级
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
}
