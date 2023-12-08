package org.example.ch18_reflection.sec_04_operate_objects_using_reflection;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class A_ObjectPoolFactory {
    // 定义一个对象池，前面是对象名，后面是实际对象
    private Map<String, Object> objectPool = new HashMap<>();

    // 定义一个创建对象的方法
    // 该方法只要传入一个字符串类名，程序可以根据该类名生成Java对象
    private Object createObject(String clazzName) throws Exception {
        // 根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);
        // 使用clazz对应类的默认构造器创建实例
        return clazz.getConstructor().newInstance();
    }

    // 该方法根据指定外键来初始化对象池
    // 它会根据配置文件来创建对象
    public void initPool(String fileName) {
        try (
                var fis = new FileInputStream(fileName)
        ) {
            var props = new Properties();
            props.load(fis);
            for (String name : props.stringPropertyNames()) {
                // 每取出一对key-value对，就根据value创建一个对象
                // 调用createObject()创建对象，并将对象添加到对象池中
                objectPool.put(name, createObject(props.getProperty(name)));
            }
        } catch (Exception ex) {
            System.out.println("读取" + fileName + "异常");
        }
    }

    public Object getObject(String name) {
        // 从objectPool中取出指定name对应的对象
        return objectPool.get(name);
    }

    public static void main(String[] args) {
        var pf = new A_ObjectPoolFactory();
        pf.initPool("data/ch18/4_1_obj.txt");
        System.out.println(pf.getObject("a"));
        System.out.println(pf.getObject("b"));
    }
}
