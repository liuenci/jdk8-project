package com.cier.thread;

public class Demo6 {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println(getName() + " AAAAAAAAA");
                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println(getName() + " BB");
                }
            }
        };
        // 设置线程为守护线程 当要守护的线程结束之后该守护线程直接就挂掉了，但是有一定的缓冲时间。
        thread2.setDaemon(true);
        thread.start();
        thread2.start();
    }
}
