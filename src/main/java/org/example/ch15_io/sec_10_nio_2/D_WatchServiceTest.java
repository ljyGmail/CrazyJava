package org.example.ch15_io.sec_10_nio_2;

import java.nio.file.*;

public class D_WatchServiceTest {
    public static void main(String[] args) throws Exception {
        // 获取文件系统的WatchService对象
        WatchService watchService = FileSystems.getDefault().newWatchService();
        // 为CL盘根目录注册监听
        Paths.get("C:/temp").register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE);
        while (true) {
            // 获取下一个文件变化事件
            WatchKey key = watchService.take();
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.context() + " 文件发生了 " + event.kind() + "事件!");
            }
            // 重设WatchKey
            boolean valid = key.reset();
            // 如果重设失败，退出监听
            if (!valid) {
                break;
            }
        }
    }
}
