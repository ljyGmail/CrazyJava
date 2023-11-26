package org.example.ch16_multi_threading.sec_05_thread_synchronization;

public class B_DrawThread extends Thread {
    // 模拟用户账户
    private A_Account account;
    // 当前取钱线程所希望取的钱数
    private double drawAmount;

    public B_DrawThread(String name, A_Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }
    // 当多个线程修改同一个共享数据时，将涉及数据安全问题

    @Override
    public void run() {
        // 账户余额大于取钱数目
        if (account.getBalance() >= drawAmount) {
            // 吐出钞票
            System.out.println("取钱成功！吐出钞票: " + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            // 修改余额
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println("\t余额为: " + account.getBalance());
        } else {
            System.out.println(getName() + "取钱失败！余额不足！");
        }
    }
}
