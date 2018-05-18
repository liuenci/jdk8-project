package com.cier.lambda;

import java.util.ArrayList;
import java.util.List;

public class NewFeaturesTester {
    final static String salution = "hello ";

    public static void main(String[] args) {
        NewFeaturesTester newFeaturesTester = new NewFeaturesTester();
        // 带有类型声明的表达式
        MathOperation addition = (int a, int b) -> a + b;
        // 没有类型声明的表达式
        MathOperation subtraction = (a, b) -> a - b;
        // 带有大括号、带有返回值的表达式
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有大括号和return语句的表达式
        MathOperation division = (int a, int b) -> a / b;
        System.out.println("10 + 5 = " + newFeaturesTester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + newFeaturesTester.operate(10, 5, subtraction));
        System.out.println("10 * 5 = " + newFeaturesTester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + newFeaturesTester.operate(10, 5, division));

        GreetingService greetingService = message ->
                System.out.println(salution + message);
        greetingService.sayMessage("cier");

        List names = new ArrayList();
        names.add("Peter");
        names.add("Linda");
        names.add("Smith");
        names.add("Zack");
        names.add("Bob");
        // 通过 Systom.out::println 引用了输出的方法
        names.forEach(System.out::println);
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
