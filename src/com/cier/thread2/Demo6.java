package com.cier.thread2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo6 {

    public static void main(String[] args) {
        final Printer3 printer3 = new Printer3();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        printer3.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        printer3.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        printer3.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

class Printer3 {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition1 = reentrantLock.newCondition();
    private Condition condition2 = reentrantLock.newCondition();
    private Condition condition3 = reentrantLock.newCondition();

    private int flag = 1;

    public void print1() throws InterruptedException {
        // 获取锁
        reentrantLock.lock();
        if (flag != 1) {
            condition1.await();
        }
        System.out.print("程");
        System.out.print("序");
        System.out.print("员");
        System.out.print("牛");
        System.out.print("逼");
        System.out.println();
        flag = 2;
        // 随机唤醒单个等待的线程
        condition2.signal();
        // 释放锁
        reentrantLock.unlock();
    }

    public void print2() throws InterruptedException {
        reentrantLock.lock();
        if (flag != 2) {
            condition2.await();
        }
        System.out.print("湖");
        System.out.print("工");
        System.out.print("大");
        System.out.println();
        flag = 3;
        condition3.signal();
        reentrantLock.unlock();
    }

    public void print3() throws InterruptedException {
        reentrantLock.lock();
        if (flag != 3) {
            condition3.signal();
        }
        System.out.print("R");
        System.out.print("N");
        System.out.print("G");
        System.out.println();
        flag = 1;
        condition1.signal();
        reentrantLock.unlock();
    }
}
