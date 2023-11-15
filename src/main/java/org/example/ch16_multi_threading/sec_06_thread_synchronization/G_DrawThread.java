package org.example.ch16_multi_threading.sec_06_thread_synchronization;

public class G_DrawThread extends Thread {
    // 模拟用户账户
    private F_Account account;
    // 当前取钱线程所希望的钱数
    private double drawAmount;

    public G_DrawThread(String name, F_Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        // 直接调用account对象的draw()方法来执行取钱操作
        // 同步方法的同步监视器是this，this代表调用draw()方法的对象
        // 也就是说，线程进入draw()方法之前，必须先对account对象加锁
        account.draw(drawAmount);
    }
}
