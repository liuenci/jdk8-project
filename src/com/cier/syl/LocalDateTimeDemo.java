package com.cier.syl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        // 获取当前的日期和时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // 输出当前时间的本地值
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        Month month = localDate.getMonth();
        System.out.println(month.getValue());
        System.out.println(month);

        // 由当前时间附带月份和年再输出
        System.out.println(localDateTime.withDayOfMonth(12).withYear(2012).withSecond(33));

        // 输出 2016 年圣诞节的日期
        System.out.println(LocalDate.of(2016,Month.DECEMBER,25));

        // 输出新闻联播开始的时间
        System.out.println(LocalTime.of(19,00));

        // 转化为字符串输出
        LocalTime localTime = LocalTime.parse("20:14:22");
        System.out.println(localTime);
    }
}
