package org.example.ch16_multi_threading.sec_06_thread_synchronization;

public class J_DrawThread extends Thread {
    // 模拟用户账户
    private I_Account account;
    // 当前取钱线程所希望的钱数
    private double drawAmount;

    public J_DrawThread(String name, I_Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        account.draw(drawAmount);
    }
}
