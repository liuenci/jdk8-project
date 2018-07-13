package com.cier.syn;

/**
 * 同步代码块
 */
public class Demo1 {

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

class Printer {
    Demo demo = new Demo();
    public void print1() {
        // 同步代码块,锁机制，所对象可以是任意的
        synchronized(demo){
            System.out.print("程");
            System.out.print("序");
            System.out.print("员");
            System.out.println();
        }
    }

    public void print2() {
        synchronized (demo){
            System.out.print("湖");
            System.out.print("工");
            System.out.print("大");
            System.out.println();
        }
    }
}
class Demo{

}