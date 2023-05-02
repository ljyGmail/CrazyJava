package org.example.ch06_oop2.sec_04_final;

class Name {
    private String firstName;
    private String lastName;

    public Name() {
    }

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

public class L_Student {
    private final Name name;

    public L_Student(Name name) {
        // this.name = name;

        // 设置name实例变量为临时创建的Name对象，该对象的firstName和lastName
        // 与传入的name参数的firstName和lastName相同
        this.name = new Name(name.getFirstName(), name.getLastName());
    }

    public Name getName() {
        // return name;

        // 返回一个匿名对象，该对象的firstName和lastName
        // 与该对象里的name的firstName和lastName相同
        return new Name(name.getFirstName(), name.getLastName());
    }

    public static void main(String[] args) {
        var n = new Name("悟空", "孙");
        var p = new L_Student(n);
        // Student对象的name的firstName值为悟空
        System.out.println(p.getName().getFirstName());
        // 改变Student对象的name的firstName值
        n.setFirstName("八戒");
        // Student实现的name的firstName值被改为"八戒"
        System.out.println(p.getName().getFirstName());
    }
}
