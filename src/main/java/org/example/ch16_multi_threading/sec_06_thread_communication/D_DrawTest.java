package org.example.ch16_multi_threading.sec_06_thread_communication;

public class D_DrawTest {
    public static void main(String[] args) {
        // 创建一个账户
        var acct = new A_Account("1234567", 0);
        new B_DrawThread("取钱者", acct, 800).start();
        new C_DepositThread("存款者甲", acct, 800).start();
        new C_DepositThread("存款者乙", acct, 800).start();
        new C_DepositThread("存款者丙", acct, 800).start();
    }
}
