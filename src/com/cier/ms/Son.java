package com.cier.ms;

public class Son extends Father {
    public static void main(String[] args) throws CloneNotSupportedException {
        new Son().fun();
        new Son().clone();
    }
}
