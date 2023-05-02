package org.example.ch06_oop2.sec_04_final;

public class K_Address {
    private final String detail;
    private final String postCode;

    // 在构造器里初始化两个实例变量
    public K_Address(String detail, String postCode) {
        this.detail = detail;
        this.postCode = postCode;
    }

    public String getDetail() {
        return detail;
    }

    public String getPostCode() {
        return postCode;
    }

    // 重写equals()方法，判断两个对象是否相等
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == K_Address.class) {
            var ad = (K_Address) obj;
            // 当detail和postCode相等时，可认为两个Address对象相等
            if (this.getDetail().equals(ad.getDetail()) && this.getPostCode().equals(ad.getPostCode())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return detail.hashCode() + postCode.hashCode() * 31;
    }
}
