package org.example.ch15_io.sec_09_nio;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public class G_FileLockTest {
    public static void main(String[] args) throws Exception {
        try (
                // 使用FileOutputStream获取FileChannel
                var channel = new FileOutputStream("data/ch15/9_2_a.txt").getChannel()) {
            // 使用非阻塞式方式对指定文件加锁
            FileLock lock = channel.tryLock();
            // 程序暂停10s
            Thread.sleep(10000);
            // 释放锁
            lock.release();
        }
    }
}
