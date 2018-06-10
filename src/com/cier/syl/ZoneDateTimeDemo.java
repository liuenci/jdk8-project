package com.cier.syl;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeDemo {
    public static void main(String[] args) {
        // 将字符串代表的时区信息转化
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2016-04-20T19:22:15+01:30[Europe/Paris]");
        System.out.println(zonedDateTime);

        // 设定地区 ID 为亚洲的加尔各答（位于印度）,并输出
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        System.out.println(zoneId);

        // 获取系统默认的当前时区并输出
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println(currentZone);
    }
}
