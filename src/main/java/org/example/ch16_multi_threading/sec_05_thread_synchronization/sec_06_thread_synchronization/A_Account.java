package org.example.ch16_multi_threading.sec_05_thread_synchronization.sec_06_thread_synchronization;

public class A_Account {
    // 封装账户编号、账户余额的两个成员变量
    private String accountNo;
    private double balance;

    // 构造器
    public A_Account() {
    }

    public A_Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 下面两个方法根据accountNo来重写hashCode()和equals()方法
    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null && obj.getClass() == A_Account.class) {
            var target = (A_Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}
