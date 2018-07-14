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

/**
 * 在同步代码块中，用哪个对象锁，就用哪个对象调用 wait 方法
 * 为什么 wait 方法和 notify 方法定义在 Object 类中？ 因为所对象可以是任意对象，Object 是所有的类的基类，所以 wait 和 notify 方法需要定义在 Object 这个类中
 * sleep 方法和 wait 方法的区别？ sleep 方法必须传入参数，参数就是时间，时间到了自动醒来。wait 方法可以传入参数，也可以不传入参数，传入参数就是在参数的时间结束后等待，不传入就是直接等待。
 * sleep 方法在同步函数或同步代码块中，不释放锁，睡着了也抱着锁睡。wait 方法在同步函数或者同步代码块中，释放锁。
 */
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
