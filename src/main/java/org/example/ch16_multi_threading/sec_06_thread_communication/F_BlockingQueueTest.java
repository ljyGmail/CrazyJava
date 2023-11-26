package org.example.ch16_multi_threading.sec_06_thread_communication;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class F_BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        // 定义一个长度为2的阻塞队列
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        bq.put("Java"); // 与bq.add("Java"), bq.offer("Java")相同
        bq.put("Java"); // 与bq.add("Java"), bq.offer("Java")相同
        bq.put("Java"); // 阻塞线程
    }
}
