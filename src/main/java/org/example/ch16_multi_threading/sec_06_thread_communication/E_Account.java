package org.example.ch16_multi_threading.sec_06_thread_communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E_Account {
    // 显示定义Lock对象
    private final Lock lock = new ReentrantLock();
    // 获得指定Lock对象对应的Condition
    private final Condition cond = lock.newCondition();
    // 封装账户编号、账户余额的两个成员变量
    private String accountNo;
    private double balance;
    // 标识账户中是否已有存款的旗标
    private boolean flag = false;

    // 构造器
    public E_Account() {
    }

    public E_Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    // 因为账户金额不允许随便修改，所以只为balance提供getter方法
    public double getBalance() {
        return balance;
    }

    public void draw(double drawAmount) {
        // 加锁
        lock.lock();
        try {
            // 如果flag为假，表明账户中还没有人存钱进去，取钱方法阻塞
            if (!flag) {

                cond.await();
            } else {
                // 执行取钱操作
                System.out.println(Thread.currentThread().getName() + " 取钱: " + drawAmount);
                balance -= drawAmount;
                System.out.println("账户余额为: " + balance);
                // 将标识账户是否已有存款的旗标设为false
                flag = false;
                // 唤醒其他线程
                cond.signalAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally { //  使用finally块来释放锁
            lock.unlock();
        }
    }

    public void deposit(double depositAmount) {
        lock.lock();
        try {
            // 如果flag为真，表明账户中已有人存钱进去，存钱方法阻塞
            if (flag) {
                cond.await();
            } else {
                // 执行存款操作
                System.out.println(Thread.currentThread().getName() + " 存款: " + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为: " + balance);
                // 将表示账户是否已有存款的旗标设为true
                flag = true;
                // 唤醒其他线程
                cond.signalAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally { // 使用finally块来释放锁
            lock.unlock();
        }
    }
}
