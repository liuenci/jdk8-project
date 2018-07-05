package com.cier.zy;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class LocalDateTimeDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入年份:");
        int year = scanner.nextInt();
        System.out.print("亲输入月份:");
        int month = scanner.nextInt();
        System.out.println("一\t二\t三\t四\t五\t六\t日");
        LocalDate localDate = LocalDate.of(year, month, 1);
        // 计算当月的第一天
        int n = localDate.getDayOfWeek().getValue();
        for (int i = 0; i < n - 1; i++) {
            System.out.print("\t");
        }
        while (localDate.getMonth().getValue() == month) {
            System.out.print(localDate.getDayOfMonth() + "\t");
            if (localDate.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }
            localDate = localDate.plus(1, ChronoUnit.DAYS);
        }
    }
}
