package org.example.ch15_io.sec_08_java9_improved_serialization;

import java.io.FileInputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;

public class H_FilterTest {
    public static void main(String[] args) {
        try (
                // 创建一个ObjectInputStream输入流
                var ois = new ObjectInputStream(new FileInputStream("data/ch15/object.txt"))) {
            ois.setObjectInputFilter((info) -> {
                System.out.println("===执行数据过滤===");
                ObjectInputFilter serialFilter = ObjectInputFilter.Config.getSerialFilter();
                if (serialFilter != null) {
                    // 首先使用ObjectInputFilter执行默认的检查
                    ObjectInputFilter.Status status = serialFilter.checkInput(info);
                    // 如果默认检查的结果不是Status.UNDECIDED
                    if (status != ObjectInputFilter.Status.UNDECIDED) {
                        // 直接返回检查结果
                        return status;
                    }
                }
                // 如果要恢复的对象不是1个
                if (info.references() != 1) {
                    // 不允许恢复对象
                    return ObjectInputFilter.Status.REJECTED;
                }
                // 如果恢复的不是Person类
                if (info.serialClass() != null && info.serialClass() != A_Person.class) {
                    // 不允许恢复对象
                    return ObjectInputFilter.Status.REJECTED;
                }
                return ObjectInputFilter.Status.UNDECIDED;
            });

            // 从输入流中读取一个Java对象，并将其强制类型转换为Person类
            var p = (A_Person) ois.readObject();
            System.out.println("名字为: " + p.getName() + "\n年龄为: " + p.getAge());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
