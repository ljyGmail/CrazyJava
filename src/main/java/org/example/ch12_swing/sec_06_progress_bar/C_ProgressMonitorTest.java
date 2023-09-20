package org.example.ch12_swing.sec_06_progress_bar;

import javax.swing.*;

public class C_ProgressMonitorTest {
    Timer timer;

    public void init() {
        final var target = new SimulatedActivity(1000);
        // 以启动一条线程的方式来执行一个耗时的任务
        final var targetThread = new Thread(target);
        targetThread.start();
        final var dialog = new ProgressMonitor(null, "等待任务完成", "已完成：", 0, target.getAmount());
        timer = new Timer(300, e -> {
            // 以任务的当前完成量设置进度对话框的完成比例
            dialog.setProgress(target.getCurrent());
            // 如果用户单击了进度对话框的"取消"按钮
            if (dialog.isCanceled()) {
                // 停止计时器
                timer.stop();
                // 中断任务的执行线程
                targetThread.interrupt();
                // 系统退出
                System.exit(0);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new C_ProgressMonitorTest().init();
    }
}
