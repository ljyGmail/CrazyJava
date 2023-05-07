package org.example.ch06_oop2.sec_09_enum;

public enum E_Gender {
    MALE, FEMALE;
    private String name;

    public void setName(String name) {
        switch (this) {
            case MALE:
                if (name.equals("男")) {
                    this.name = name;
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
            case FEMALE:
                if (name.equals("女")) {
                    this.name = name;
                } else {
                    System.out.println("参数错误");
                    return;
                }
                break;
        }
    }

    public String getName() {
        return this.name;
    }
}
