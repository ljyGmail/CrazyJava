package org.example.ch06_oop2.sec_09_enum;

public enum G_Gender {
    // 此处的枚举值必须调用对应的构造器来创建
    MALE("男"), FEMALE("女");
    private final String name;

    // 枚举类的构造器只能使用private修饰
    private G_Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
