package com.cier.zy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("中国", "加拿大", "美国", "中国共和国", "日本");
        // A、打印出国家名为两个字的国家
        System.out.println(stringList.stream().filter(s -> s.length() == 2).collect(Collectors.toList()));
        // B、打印出国家名以“中”开头的国定
        System.out.println(stringList.stream().filter(s -> s.startsWith("中")).collect(Collectors.toList()));
        // C、按国家名的长度从小到大输出
        System.out.println(stringList.stream().sorted((o1, o2) -> o1.length() - o2.length()).collect(Collectors.toList()));
        // D、判断所有的国家是否都是以“共和国”结尾

        System.out.println(stringList.stream().allMatch(s -> s.endsWith("共和国")));
        // E、输出前3个国家
        System.out.println(stringList.stream().limit(3).collect(Collectors.toList()));
    }

}
