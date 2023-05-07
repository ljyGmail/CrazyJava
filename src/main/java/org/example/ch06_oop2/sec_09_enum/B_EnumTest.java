package org.example.ch06_oop2.sec_09_enum;

public class B_EnumTest {
    public void judge(A_SeasonEnum s) {
        // switch语句里的表达式可以是枚举值
        switch (s) {
            case SPRING:
                System.out.println("春暖花开，正好踏青");
                break;
            case SUMMER:
                System.out.println("夏日炎炎，适合游泳");
                break;
            case FALL:
                System.out.println("秋高气爽，进补及时");
                break;
            case WINTER:
                System.out.println("冬日雪飘，围炉赏雪");
                break;
        }
    }

    public static void main(String[] args) {
        // 枚举类默认有一个values()方法，返回该枚举类的所有实例
        for (var s : A_SeasonEnum.values()) {
            System.out.println(s);
        }

        // 使用枚举实例时，可通过EnumClass.variable的形式来访问
        new B_EnumTest().judge(A_SeasonEnum.SPRING);

        // java.lang.Enum类中所包含的方法:
        System.out.println(A_SeasonEnum.WINTER.compareTo(A_SeasonEnum.FALL));
        System.out.println(A_SeasonEnum.SPRING.name());
        System.out.println(A_SeasonEnum.SPRING.toString());
        System.out.println(A_SeasonEnum.WINTER.ordinal());

        A_SeasonEnum summer = Enum.valueOf(A_SeasonEnum.class, "SUMMER");
        System.out.println(summer);
    }
}
