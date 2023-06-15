package org.example.ch09_generics.sec_02_generics_going_deeper;


public class C_A2 extends A_Apple {
    // 重写父类的方法
    public String getInfo()
    {
        // super.getInfo()方法返回值是Object类型
        // 所以加toString()才返回String类型
        return super.getInfo().toString();
    }
}
