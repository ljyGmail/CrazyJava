package org.example.ch14_annotation.sec_04_apt;

@A_Persistent(table = "person_inf")
public class D_Person {

    @B_Id(column = "person_id", type="integer", generator = "identity")
    private int id;

    @C_Property(column = "person_name", type = "string")
    private String name;

    @C_Property(column = "person_age", type = "integer")
    private int age;

    // 无参数的构造器
    public D_Person() {
    }

    // 初始化全部成员变量的构造器

    public D_Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
