package com.java.algorithm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wendyhe on 2018/8/13.
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        String str_date1 = "2018-08-13";
        String str_date2 = "2018-07-28";
        test(str_date1,str_date2);


    }
    public static void test(String str_date1,String str_date2) throws ParseException {

        //得到日期的DateFormat对象
        DateFormat dateFormat = DateFormat.getDateInstance();
        //自定义日期风格
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = dateFormat.parse(str_date1);
        Date date2 = dateFormat.parse(str_date2);

        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long time = Math.abs(time1-time2);

        int day = (int) (time/1000/60/60/24);
        System.out.println(day);
    }

    public static void DateAPI(){

        // Clock 类提供了访问当前日期和时间的方法，Clock 是时区敏感的，可以用来取代 System.currentTimeMillis() 来获取当前的微秒数。
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);//1552379579043
        //某一个特定的时间点也可以使用 Instant 类来表示，Instant 类也可以用来创建旧版本的java.util.Date 对象。
        Instant instant = clock.instant();
        System.out.println(instant);
        Date legacyDate = Date.from(instant); //2019-03-12T08:46:42.588Z
        System.out.println(legacyDate);//Tue Mar 12 16:32:59 CST 2019


        // 在新API中时区使用 ZoneId 来表示。时区可以很方便的使用静态方法of来获取到。
        // 抽象类ZoneId（在java.time包中）表示一个区域标识符。
        // getAvailableZoneIds的静态方法，它返回所有区域标识符。
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());// ZoneRules[currentStandardOffset=+01:00]
        System.out.println(zone2.getRules());// ZoneRules[currentStandardOffset=-03:00]


        // LocalTime 定义了一个没有时区信息的时间，例如 晚上10点或者 17:30:15。
        // 创建了两个本地时间,之后比较时间并以小时和分钟为单位计算两个时间的时间差
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);
        System.out.println(now1.isBefore(now2));  // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -3
        System.out.println(minutesBetween);     // -239

        // LocalTime 提供了多种工厂方法来简化对象的创建，包括解析时间字符串.
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59
        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime);   // 13:37
    }

}
