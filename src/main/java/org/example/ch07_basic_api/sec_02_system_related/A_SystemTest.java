package org.example.ch07_basic_api.sec_02_system_related;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

public class A_SystemTest {
    public static void main(String[] args) throws Exception {
        // 获取系统所有的环境变量
        Map<String, String> env = System.getenv();
        for (var name : env.keySet()) {
            System.out.println(name + " ---> " + env.get(name));
        }

        // 获取指定环境变量的值
        System.out.println(System.getenv("PATH"));
        // 获取所有的系统属性
        Properties props = System.getProperties();
        // 将所有的系统属性保存到props.txt文件中
        props.store(new FileOutputStream("data/ch07/props.txt"),"System Properties");
        // 输出特定的系统属性
        System.out.println(System.getProperty("os.name"));
    }
}
