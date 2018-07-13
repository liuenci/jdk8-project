package com.cier.thread;

public class Demo7 {
    public static void main(String[] args) {
        final Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName() + " " + i);
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    // 当线程加入时，线程会执行完才执行下一个线程
                    if (i == 2) {
                        try {
                            thread.join(1); // 插队指定的时间，过了指定的时间之后，两条线程交替执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName() + " " + i );
                }
            }
        };

        thread.start();
        thread1.start();
    }
}
