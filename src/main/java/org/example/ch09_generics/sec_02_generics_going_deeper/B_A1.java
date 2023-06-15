package org.example.ch09_generics.sec_02_generics_going_deeper;

public class B_A1 extends A_Apple<String> {
    // 正确重写了父类的方法
    // 其返回值与父类Apple<String>的返回值完全相同
    public String getInfo() {
        return "子类" + super.getInfo();
    }

    /*
    // 下面方法是错误的，重写父类方法时返回值类型不一致
    public Object getInfo()
    {
        return "子类"
    }
     */
}
