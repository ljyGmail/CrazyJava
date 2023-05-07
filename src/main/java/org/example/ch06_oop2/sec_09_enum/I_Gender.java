package org.example.ch06_oop2.sec_09_enum;

public enum I_Gender implements H_GenderDesc {

    MALE("男"), FEMALE("女");
    private String name;

    private I_Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void info() {
        System.out.println("这是一个用于定义性别的枚举类");
    }
}
