package org.example.ch16_multi_threading.sec_05_thread_synchronization.sec_06_thread_synchronization;

public class K_DrawTest4 {

    public static void main(String[] args) {
        // 创建一个账户
        var acct = new I_Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new J_DrawThread("甲", acct, 800).start();
        new J_DrawThread("乙", acct, 800).start();
    }
}
