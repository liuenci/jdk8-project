package com.cier.thread;

public class Demo9 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + " .aaaaa");
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(getName() + " .bbbbbb");
                }
            }
        };

        thread.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        thread1.start();
    }
}
