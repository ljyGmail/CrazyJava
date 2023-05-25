package org.example.ch07_basic_api.sec_07_java11_improved_i18n_format;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class D_LoggerTest {
    public static void main(String[] args) throws Exception {
        // 获取System.Logger对象
        var logger = System.getLogger("fkjava");
        // 设置系统日志级别(FINE对应DEBUG)
        Logger.getLogger("fkjava").setLevel(Level.INFO);
        // 设置使用a.xml保存日志记录
        Logger.getLogger("fkjava").addHandler(new FileHandler("a.xml"));
        logger.log(System.Logger.Level.DEBUG, "debug信息");
        logger.log(System.Logger.Level.INFO, "info信息");
        logger.log(System.Logger.Level.ERROR, "error信息");
    }
}
