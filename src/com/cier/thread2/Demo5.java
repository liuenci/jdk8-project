package com.cier.thread2;

public class Demo5 {

    public static void main(String[] args) {
        Printer2 printer2 = new Printer2();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        printer2.print1();
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
                        printer2.print2();
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
                        printer2.print3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
class Printer2 {
    private int flag = 1;
    public  void print1() throws InterruptedException {
        synchronized (this){
            while (flag != 1){
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
            this.notifyAll();
        }
    }

    public void print2() throws InterruptedException {
        synchronized (this) {
            while (flag != 2) {
                this.wait();
            }
            System.out.print("湖");
            System.out.print("工");
            System.out.print("大");
            System.out.println();
            flag = 3;
            this.notifyAll();
        }
    }
    public void print3() throws InterruptedException {
        synchronized (this) {
            while (flag != 3) {
                this.wait();
            }
            System.out.print("R");
            System.out.print("N");
            System.out.print("G");
            System.out.println();
            flag = 1;
            this.notifyAll();
        }
    }
}
