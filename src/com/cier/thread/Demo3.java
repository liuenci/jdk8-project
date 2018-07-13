package com.cier.thread;

public class Demo3 {

    public static void main(String[] args) {
        // 继承 Thread 类
        new Thread() {
            // 重写 run 方法
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    System.out.println("aaaaaaaa");
                }
            }
            // 开启线程
        }.start();

        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    System.out.println("不和你多 BB");
                }
            }
        }).start();

    }
}
