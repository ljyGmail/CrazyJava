package org.example.ch16_multi_threading.sec_06_thread_communication;

public class C_DepositThread extends Thread {
    private A_Account account;
    // 当前存款线程所希望存的钱数
    private double depositAmount;

    public C_DepositThread(String name, A_Account account, double depositAmount) {
        super(name);
        this.account = account;
        this.depositAmount = depositAmount;
    }

    // 重复100次执行存款操作

    @Override
    public void run() {
        for (var i = 0; i < 100; i++) {
            account.deposit(depositAmount);
        }
    }
}
