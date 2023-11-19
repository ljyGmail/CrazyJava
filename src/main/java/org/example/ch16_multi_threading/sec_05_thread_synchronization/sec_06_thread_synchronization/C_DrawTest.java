package org.example.ch16_multi_threading.sec_05_thread_synchronization.sec_06_thread_synchronization;

public class C_DrawTest {
    public static void main(String[] args) {
        // 创建一个账户
        var acct = new A_Account("1234567", 1000);
        // 模拟两个线程对同一个账户取钱
        new B_DrawThread("甲", acct, 800).start();
        new B_DrawThread("乙", acct, 800).start();
    }
}
