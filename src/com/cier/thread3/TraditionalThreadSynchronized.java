package com.cier.thread3;

import java.io.ObjectOutputStream;

public class TraditionalThreadSynchronized {

    public static void main(String[] args) {
        Output output = new Output();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    output.output("陈浩民");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    output.output("张卫健");
                }
            }
        }).start();
    }
}
class Output {
    // 同步方法块
    /*public synchronized void output(String name) {
        int len = name.length();
        for (int i = 0; i < len; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.println();
    }*/
    // String 不可变，也能实现同步
    /*public void output(String name) {
        String syn = "";
        synchronized (syn) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }*/
    // 使用 this
    /*public void output(String name) {
        synchronized (this) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }*/

    // 使用字节码实现同步
    public void output(String name) {
        synchronized (Output.class) {
            int len = name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }

}