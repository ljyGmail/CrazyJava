package org.example.ch05_oop1.sec_07_polymorphism;

public class B_ConversionTest {
    public static void main(String[] args) {
        var d = 13.4;
        var l = (long) d;
        System.out.println(l);
        var in = 5;
        // 试图把一个数值类型的变量转换为boolean类型，下面代码编译出错
        // 编译时会提示：不可转换的类型
        // var b = (boolean) in;
        Object obj = "Hello";
        // obj变量的编译时类型为Object, Object与String存在继承关系，可以强制类型转换
        // 而且obj变量的实际类型时String, 所以运行时也可通过
        var objStr = (String) obj;
        System.out.println(objStr);
        // 定义一个objPri变量，编译时类型为Object, 实际类型为Integer
        Object objPri = Integer.valueOf(5);
        // objPri变量的变量时类型为Object, objPri的运行时类型为Integer
        // Object与Integer存在继承关系
        // 可以强制类型转换，而objPri变量的实际类型时Integer
        // 所以下面代码运行时引发ClassCastException异常
        // var str = (String) objPri;

        // 为了让程序更加健壮，可以将代码改为如下
        if (objPri instanceof String) {
            var str = (String) objPri;
        }
    }
}
