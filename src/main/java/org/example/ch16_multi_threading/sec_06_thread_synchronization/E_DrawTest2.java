package org.example.ch16_multi_threading.sec_06_thread_synchronization;

public class E_DrawTest2 {
    public static void main(String[] args) {
        // 创建一个账户
        var acct = new A_Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new D_DrawThread("甲", acct, 800).start();
        new D_DrawThread("乙", acct, 800).start();
    }
}
