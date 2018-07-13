package com.cier.thread;

/**
 * 礼让线程
 */
public class Demo8 {


    public static void main(String[] args) {

        new MyThread1().start();
        new MyThread1().start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            if (i % 10 == 0) {
                Thread.yield();
            }
            System.out.println(getName() + " " + i);
        }
    }
}
