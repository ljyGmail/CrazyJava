package org.example.ch06_oop2.sec_02_object_handling;

class God {
    private String name;
    private String idStr;

    public God() {
    }

    public God(String name, String idStr) {
        this.name = name;
        this.idStr = idStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    // 重写equals()方法，提供自定义的相等标准
    public boolean equals(Object obj) {
        // 如果两个对象为同一个对象
        if (this == obj)
            return true;
        // 只有当obj是God对象
        if (obj != null && obj.getClass() == God.class) {
            var godObj = (God) obj;
            // 并且当前对象的idStr与obj对象的idStr相等时才可判断两个对象相等
            if (this.getIdStr().equals(godObj.getIdStr())) {
                return true;
            }
        }
        return false;
    }
}

public class F_OverrideEqualsRight {
    public static void main(String[] args) {
        var g1 = new God("孙悟空", "12343433433");
        var g2 = new God("孙行者", "12343433433");
        var g3 = new God("孙悟饭", "99933433");

        // g1和g2的idStr相等，所以输出true
        System.out.println("g1和g2是否相等? " + g1.equals(g2));

        // g2和g3的idStr不相等，所以输出false
        System.out.println("g2和g3是否相等? " + g2.equals(g3));
    }
}
