package com.cier.exception;

public class Demo1 {

    public static void main(String[] args) {
        System.out.println(getNum());
    }

    public static int getNum(){
        try{
            System.out.println("测试");
            int i = 1/0;
            return 1;
        } catch (Exception e){
            return 2;
        } finally {
            System.out.println("测试哦");
            return 3;
        }
    }
}
