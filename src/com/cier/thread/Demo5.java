package com.cier.thread;

public class Demo5 {

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + " AA");
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + " BB");
                }
            }
        }.start();
    }

    /**
     * 线程睡眠
     *
     * @throws InterruptedException
     */
    public static void demo1() throws InterruptedException {
        for (int i = 20; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.println("倒计时" + i + "秒");
        }
        for (int i = 20; i >= 0; i--) {
            Thread.sleep(1000);
            System.out.println("倒计时" + i + "秒");
        }
    }
}
