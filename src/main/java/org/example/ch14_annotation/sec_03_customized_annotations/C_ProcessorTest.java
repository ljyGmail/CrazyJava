package org.example.ch14_annotation.sec_03_customized_annotations;

import java.lang.reflect.Method;

public class C_ProcessorTest {
    public static void process(String clazz) throws ClassNotFoundException {
        int passed = 0;
        int failed = 0;
        // 遍历clazz对应的类里的所有方法
        for (Method m : Class.forName(clazz).getMethods()) {
            // 如果该方法使用了@A_Testable修饰
            if (m.isAnnotationPresent(A_Testable.class)) {
                try {
                    // 调用m方法
                    m.invoke(null);
                    // 测试成功，passed计数器加1
                    passed++;
                } catch (Exception ex) {
                    System.out.println("方法" + m + "运行失败，异常: " + ex.getCause());
                    // 测试出现异常，failed计数器加1
                    failed++;
                }
            }
        }
        // 统计测试结果
        System.out.println("共运行了: " + (passed + failed) + "个方法，其中: \n失败了: " + failed + "个，\n成功了: " + passed + "个!");
    }
}
