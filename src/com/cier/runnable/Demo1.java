package com.cier.runnable;

public class Demo1 {


    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        // 把 Runnable 实现类作为构造参数传递给 Thread 的构造方法
        Thread thread = new Thread(myRunnable);
        thread.start();

        for (int i = 0; i < 1000; i++){
            System.out.println("b");
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++){
            System.out.println("aaa");
        }
    }
}
