package com.cier.syl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodAndDuration {

    public static void main(String[] args) {
        // 获取当前的时间
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // 在当前时间上增加一个月的时间
        LocalDate localDate1 = localDate.plus(1, ChronoUnit.MONTHS);
        System.out.println(localDate1);

        // 用 between 方法计算两个日期之间的日期
        Period period = Period.between(localDate,localDate1);
        System.out.println(period.getMonths());

        LocalTime localTime = LocalTime.now();
        Duration fiveHours = Duration.ofHours(5);
        LocalTime localTime1 = localTime.plus(fiveHours);
        Duration duration = Duration.between(localTime,localTime1);
        System.out.println(duration.getSeconds());
    }
}
