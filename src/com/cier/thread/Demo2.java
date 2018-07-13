package com.cier.thread;

public class Demo2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // run 方法不会开启线程
        // myThread.run();
        // 开启线程需要时间
        myThread.start();

        for (int i = 0; i < 1000; i ++){
            System.out.println("aaa");
        }
    }
}

class MyThread extends Thread {              // 继承 Thread
    @Override
    public void run() {                      // 重写 run 方法
        for (int i = 0; i < 1000; i++) {     // 将要执行的的代码写到 run 方法中
            System.out.println("abc");
        }
    }
}
