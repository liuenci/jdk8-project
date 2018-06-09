package com.cier.syl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("Java 7 Start");

        // 统计空字符串的数量
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij", "", "lmn");
        System.out.println("List:" + strings);
        System.out.println("=========");
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Empty Strings:" + count);
        System.out.println("=========");

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
