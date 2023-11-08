package org.example.ch15_io.sec_09_nio;

import java.nio.charset.Charset;
import java.util.SortedMap;

public class E_CharsetTest {
    public static void main(String[] args) {
        // 获取Java支持的全部字符集
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for (var alias : map.keySet()) {
            // 输出字符集的别名和对应的Charset对象
            System.out.println(alias + "---->" + map.get(alias));
        }
    }
}
