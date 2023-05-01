package org.example.ch06_oop2.sec_04_final;

public class G_StringJoinTest {
    public static void main(String[] args) {
        var s1 = "疯狂Java";
        // s2变量引用的字符串可以在编译时就确定下来
        // 因此s2直接引用常量池中已有的"疯狂Java"字符串
        var s2 = "疯狂" + "Java";
        System.out.println(s1 == s2); // 输出true

        // 定义2个字符串直接量
        var str1 = "疯狂";
        var str2 = "Java";
        // 将str1和str2进行连接运算
        var s3 = str1 + str2;
        System.out.println(s1 == s3); // 输出false
    }
}
