package org.example.ch16_multi_threading.sec_06_thread_communication;

public class B_DrawThread extends Thread {
    // 模拟用户账户
    private A_Account account;
    // 当前取钱线程所希望取的签钱数
    private double drawAmount;

    public B_DrawThread(String name, A_Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    // 重复100次执行取钱操作

    @Override
    public void run() {
        for (var i = 0; i < 100; i++) {
            account.draw(drawAmount);
        }
    }
}
