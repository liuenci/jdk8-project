package com.cier.syl;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("Java 7 Start");

        // 统计空字符串的数量
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij", "", "lmn");
        System.out.println("List:" + strings);
        System.out.println();
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty Strings:" + count);
        System.out.println();
        count = getCountLength3UsingJava7(strings);
        System.out.println("字符串长度为 3 的数量:"+count);
        System.out.println();

        // 消除空字符串
        List<String> filtered = deleteEmptyStringsUsingJava7(strings);
        System.out.println(filtered);
        System.out.println();

        // 消除空字符串，同时使用逗号来连接
        String mergedString = getMergedStringUsingJava7(strings,",");
        System.out.println(mergedString);
        System.out.println();

        // 获得不同数字的平方的列表
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5,6,7);
        List<Integer> squaresList = getSquares(numbers);
        System.out.println(squaresList);
        System.out.println();

        List<Integer> integers = Arrays.asList(1,2,3,343,55,3245,54,34,54);
        System.out.println(integers);
        System.out.println(getMax(integers));
        System.out.println(getMin(integers));
        System.out.println(getSum(integers));
        System.out.println(getAverage(integers));
        System.out.println(getSquares(integers));
        System.out.println();

        // 输出十个随机数
        System.out.println("十个随机数");
        Random random = new Random();
        for (int i = 0; i < 10; i++){
            System.out.println(random.nextInt());
        }

        // 使用 Java 8 的新特性
        System.out.println(strings);
        System.out.println();

        // 判断空值
        count = strings.stream().filter(s -> s.isEmpty()).count();
        System.out.println(count);

        // 判断长度
        count = strings.stream().filter(s -> s.length()==3).count();
        System.out.println(count);

        // 删除空字符串
        filtered = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        // 去掉空字符串再合并字符串
        mergedString = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));
        System.out.println(mergedString);
        // 将集合中的数平方,去重
        squaresList = numbers.stream().map(integer -> integer * integer).distinct().collect(Collectors.toList());
        System.out.println(squaresList);
        // 统计
        IntSummaryStatistics intSummaryStatistics = integers.stream().mapToInt((x)->x).summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getSum());

        // 生成随机数
        random.ints().limit(10).forEach(System.out::println);

        // 并行处理
        count = strings.parallelStream().filter(s -> !s.isEmpty()).count();
        System.out.println(count);
    }

    /**
     * 计算集合中的空字符串
     *
     * @param strings
     * @return
     */
    public static int getCountEmptyStringUsingJava7(List<String> strings) {
        int count = 0;
        for (String string : strings) {
            if (string.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用 Java 7 版本提供的 API 来计算长度为 3 字符的字符串
     *
     * @param strings
     * @return
     */
    public static int getCountLength3UsingJava7(List<String> strings) {
        int count = 0;
        for (String string : strings) {
            if (string.length() == 3) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用 Java7 版本提供的 API 来删除空串
     *
     * @param strings
     * @return
     */
    public static List<String> deleteEmptyStringsUsingJava7(List<String> strings) {
        List<String> filteredList = new ArrayList<String>();
        for (String string : strings) {
            if (!string.isEmpty()) {
                filteredList.add(string);
            }
        }
        return filteredList;
    }

    /**
     * 使用 Java7 版本提供的 API 来获取合并后的字符串
     *
     * @param strings
     * @param separator
     * @return
     */
    public static String getMergedStringUsingJava7(List<String> strings, String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            if (!string.isEmpty()) {
                stringBuilder.append(string);
                stringBuilder.append(separator);
            }
        }
        // "aaabb"
        String mergedString = stringBuilder.toString();
        int len = separator.length();
        return mergedString.substring(0, mergedString.length() - len + 1);
    }

    /**
     * 自定义的用于计算数字的平方的方法
     *
     * @param numbers
     * @return
     */
    public static List<Integer> getSquares(List<Integer> numbers) {
        List<Integer> squareList = new ArrayList<Integer>();
        for (Integer number : numbers) {
            Integer square = new Integer(number.intValue() * number.intValue());
            if (!squareList.contains(square)) {
                squareList.add(square);
            }
        }
        return squareList;
    }

    /**
     * 自定义的用于获取 List 中最大值的方法
     *
     * @param numbers
     * @return
     */
    public static int getMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).intValue() > max) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    /**
     * 自定义的用于获得 List 中最小值的方法
     *
     * @param numbers
     * @return
     */
    public static int getMin(List<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i).intValue() < min) {
                min = numbers.get(i);
            }
        }
        return min;
    }

    /**
     * 自定义的用于获得 List 中各个数字的和的方法
     * @param numbers
     * @return
     */
    public static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    /**
     * 自定义的用于获得List中各个数字的平均值的方法
     * @param numbers
     * @return
     */
    public static double getAverage(List<Integer> numbers){
        return getSum(numbers)/numbers.size();
    }
}
