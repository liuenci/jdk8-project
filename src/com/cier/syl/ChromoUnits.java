package com.cier.syl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChromoUnits {
    public static void main(String[] args) {
        // 获得当前的日期并输出
        LocalDate today = LocalDate.now();
        System.out.println(today);
        // 在当前日期的基础上增加两周时间再输出
        LocalDate nextWeek = today.plus(2, ChronoUnit.WEEKS);
        System.out.println(nextWeek);
        // 在当前日期基础上增加 6 个月的时间再输出
        LocalDate nextMonth = today.plus(6,ChronoUnit.MONTHS);
        System.out.println(nextMonth);
        // 在当前日期的基础上增加 5 年的时间再输出
        LocalDate nextYear = today.plus(5,ChronoUnit.YEARS);
        System.out.println(nextYear);
        // 在当前日期的基础上增加 20 年的时间再输出 （一个 Decade 为 10 年）
        LocalDate nextDecade = today.plus(2,ChronoUnit.DECADES);
        System.out.println(nextDecade);
    }
}
