package com.cier.nt;


import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        // forEach
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
        // map
        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 4, 5);
        List<Integer> list1 = list.stream().map(i -> i).distinct().collect(Collectors.toList());
        list1.forEach(System.out::println);
        // filter
        List<String> strings = Arrays.asList("efg", "", "", "ss", "ss");
        long count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println(count);
        // sorted
        random.ints().limit(10).sorted().forEach(System.out::println);
        // 并行处理
        long count1 = strings.parallelStream().filter(s -> s.isEmpty()).count();
        System.out.println(count1);
        // Collector
        List<String> filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List:" + filtered);
        String mergedString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining("haha"));
        System.out.println("Merged String：" + mergedString);
        // 统计工具
        IntSummaryStatistics statistics = list.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println("Highest number in List:"+statistics.getMax());
        System.out.println("Lowest number in List:"+statistics.getMin());
        System.out.println("Sum of all numbers:"+statistics.getSum());
        System.out.println("Average of all numbers:"+statistics.getAverage());
        System.out.println("Count of all numbers:"+statistics.getCount());
    }


}
