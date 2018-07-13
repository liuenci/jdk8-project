package com.cier.syn;

public class Demo5 {
    private static String string1 = "筷子左";
    private static String string2 = "筷子右";

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (string1) {
                        System.out.println(getName() + "获取" + string1 + "等待" + string2);
                        synchronized (string2) {
                            System.out.println(getName() + "拿到" + string2 + "开吃");
                        }
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (string2) {
                        System.out.println(getName() + "获取" + string2 + "等待" + string1);
                        synchronized (string1) {
                            System.out.println(getName() + "拿到" + string1 + "开吃");
                        }
                    }
                }
            }
        }.start();
    }
}
