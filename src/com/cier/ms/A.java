package com.cier.ms;

public class A {
    static {
        System.out.println(123);
    }

    public static void main(String[] args) {

        A a1 = new A();
        A a2 = new A();
    }
}
