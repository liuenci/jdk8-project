package com.cier.thread2;

/**
 * 线程之间的通信
 */
public class Demo4 {
    /**
     * 等待唤醒机制
     *
     * @param args
     */
    public static void main(String[] args) {
        final Printer printer = new Printer();

        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        printer.print1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        printer.print2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

class Printer {
    private int flag = 1;
    public  void print1() throws InterruptedException {
        synchronized (this){
            if (flag != 1){
                // 当前线程等待
                this.wait();
            }
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.print("牛");
            System.out.print("逼");
            System.out.println();
            flag = 2;
            // 随机唤醒单个等待的线程
            this.notify();
        }
    }

    public void print2() throws InterruptedException {
        synchronized (this) {
            if (flag != 2) {
                this.wait();
            }
            System.out.print("湖");
            System.out.print("工");
            System.out.print("大");
            System.out.println();
            flag = 1;
            this.notify();
        }
    }
}
