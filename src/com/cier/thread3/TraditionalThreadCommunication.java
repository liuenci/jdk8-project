package com.cier.thread3;

/**
 * 要用到共同数据（包括同步锁）的若干个方法的时候应该归在同一个类上面，这体现了程序的高类聚
 */
public class TraditionalThreadCommunication {

    public static void main(String[] args) {
        Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 0; i < 50; i++) {
            synchronized (TraditionalThreadCommunication.class) {
                business.main(i);
            }
        }
    }
}

class Business {

    private boolean bShouldSub = true;
    public synchronized void main(int i) {
        while (!bShouldSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("序列" + i + "子线程循环第" + j + "次");
        }
        bShouldSub = false;
        this.notify();
    }

    public synchronized void sub(int i) {
        while (bShouldSub){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int j = 0; j < 100; j++) {
            System.err.println("序列" + i + "主线程循环第" + j + "次");
        }
        bShouldSub = true;
        this.notify();
    }
}