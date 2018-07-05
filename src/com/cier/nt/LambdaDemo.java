package com.cier.nt;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        Inf inf = new Inf() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        System.out.println(inf.add(2, 3));
        // lambda 表达式
        Inf inf1 = (a, b) -> a + b;
        System.out.println(inf1.add(2, 3));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // forEach
        list.forEach(e -> System.out.println(e));
        list.forEach(System.out::println);
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2 > 0 ? 1 : (o1 - o2 == 0 ? 0 : -1);
            }
        };
        System.out.println(comparator.compare(4, 4));

        // 方法引用
        Int in = new Int() {
            @Override
            public void output(int a) {
                System.out.println(a);
            }
        };
        in.output(2);
        // lambda 表达式
        Int in1 = a -> System.out.println(a);
        in1.output(5555);
        // 方法引用
        Int in2 = System.out::println;
        in2.output(222);


    }
}

interface Inf {
    int add(int a, int b);
}

interface Int {
    void output(int a);
}
