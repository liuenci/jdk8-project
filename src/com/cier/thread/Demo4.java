package com.cier.thread;

public class Demo4 {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " AA");
            }
        }.start();


        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " BB");
            }
        }).start();

        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName());
    }
}
