package com.cier.syn;

/**
 * 同步代码块
 */
public class Demo2 {

    public static void main(String[] args) {
        final Printer printer1 = new Printer();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    printer1.print1();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    printer1.print2();
                }
            }
        }.start();
    }
}

class Printer2 {
    // 同步方法只需要在方法上加 synchronized 关键字即可
    // 非静态的同步方法的锁对象是什么？
    // 非静态的同步方法的锁对象是 this
    public static synchronized void print1() {
        System.out.print("程");
        System.out.print("序");
        System.out.print("员");
        System.out.println();
    }

    public static void print2() {
        synchronized (Printer2.class) {
            System.out.print("湖");
            System.out.print("工");
            System.out.print("大");
            System.out.println();
        }
    }
}