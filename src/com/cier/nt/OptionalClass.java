package com.cier.nt;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        OptionalClass optionalClass = new OptionalClass();

        Integer value1 = null;
        Integer value2 = new Integer(5);

        // ofNullable 允许传参时传入 null
        Optional<Integer> optional = Optional.ofNullable(value1);
        // 如果传递的参数为 null,那么 of 将抛出空指针异常
        Optional<Integer> optional1 = Optional.of(value2);
        System.out.println(optionalClass.sum(optional,optional1));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b) {
        // isPresent 用于检查值是否符合
        System.out.println("First parameter is present:" + a.isPresent());
        System.out.println("Second parameter is present:" + b.isPresent());
        // 如果当前返回的是传入的默认值，orElse 将返回它
        Integer value1 = a.orElse(new Integer(0));
        // get 用于获取值，条件是这个值必须存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}
