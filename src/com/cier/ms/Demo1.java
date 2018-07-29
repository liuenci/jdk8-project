package com.cier.ms;

public class Demo1 implements inter1 {
    public static void main(String[] args) {
        System.out.println(a);
        System.out.println(inter2.a);
    }
}
interface inter1{
    int a = 10;
}
interface inter2{
    int a = 20;
}
