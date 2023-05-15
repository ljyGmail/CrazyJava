package org.example.ch07_basic_api.sec_04_java8_date_time;

import java.time.*;

public class E_NowDatePackageTest {
    public static void main(String[] args) {
        // -----下面是关于Clock的用法-----
        // 获取当前Clock
        var clock = Clock.systemUTC();
        // 通过Clock获取当前时刻
        System.out.println("当前时刻为: " + clock.instant());
        // 获取clock对应的毫秒数，与System.currentTimeMills()输出相同
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
        // -----下面是关于Duration的用法-----
        var d = Duration.ofSeconds(6000);
        System.out.println("6000秒相当于: " + d.toMinutes() + "分");
        System.out.println("6000秒相当于: " + d.toHours() + "小时");
        System.out.println("6000秒相当于: " + d.toDays() + "天");
        // 在clock基础上增加6000秒，返回新的Clock
        var clock2 = Clock.offset(clock, d);
        // 可以看到clock2与clock相差1小时40分
        System.out.println("当前时刻加6000秒为: " + clock2.instant());
        // -----下面是关于Instant的用法-----
        var instant = Instant.now();
        System.out.println(instant);
        // instant添加6000秒(即100分钟),返回新的Instant
        var instant2 = instant.plusSeconds(6000);
        System.out.println(instant2);
        // 根据字符串解析Instant对象
        var instant3 = Instant.parse("2014-02-23T10:12:35.342Z");
        System.out.println(instant3);
        // 在instant3的基础上添加5小时4分钟
        var instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant4);
        // 获取instant4的5天以前的时刻
        var instant5 = instant4.minus(Duration.ofDays(5));
        System.out.println(instant5);
        // -----下面是关于LocalDate的用法-----
        var localDate = LocalDate.now();
        System.out.println(localDate);
        // 获得2014年的第146天
        localDate = LocalDate.ofYearDay(2014, 146);
        System.out.println(localDate); // 2014-05-26
        // 设置为2014年5月21日
        localDate = LocalDate.of(2014, Month.MAY, 21);
        System.out.println(localDate); // 2014-05-21
        // -----下面是关于LocalTime的用法-----
        // 获取当前时间
        var localTime = LocalTime.now();
        System.out.println(localTime);
        // 设置为22点33分
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);
        // 返回一天中的第5503秒
        localTime = LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime); // 01:31:43
        // -----下面是关于LocalDateTime的用法-----
        // 获取当前日期，时间
        var localDateTIme = LocalDateTime.now();
        // 当前日期，时间加上25小时3分钟
        var future = localDateTIme.plusHours(25).plusMinutes(3);
        System.out.println("当前日期，时间的25小时3分之后: " + future);
        // -----下面是关于Year，YearMonth，MonthDay的用法示例-----
        var year = Year.now();
        System.out.println("当前年份: " + year);
        year = year.plusYears(5);
        System.out.println("当前年份再过5年: " + year);
        // 根据指定月份获取YearMonth
        var ym = year.atMonth(10);
        System.out.println("year年10月: " + ym); // 输出xxxx-10, xxxx代表当前年份
        // 当前年月再加5年，减3个月
        ym = ym.plusYears(5).minusMonths(3);
        System.out.println("year年10月再加5年，减3个月: " + ym);
        var md = MonthDay.now();
        System.out.println("当前月日: " + md); // 输出 --xx-xx，代表几月几日
        // 设置5月23日
        var md2 = md.with(Month.MAY).withDayOfMonth(23);
        System.out.println("5月23日为: " + md2); // 输出 --05-23
    }
}
