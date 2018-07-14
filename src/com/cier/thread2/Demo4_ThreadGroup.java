package com.cier.thread2;

public class Demo4_ThreadGroup {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("新线程组");
        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(threadGroup,myRunnable,"张三");
        Thread thread2 = new Thread(threadGroup,myRunnable,"李四");
        // 获取组名
        System.out.println(thread1.getThreadGroup().getName());
        System.out.println(thread2.getThreadGroup().getName());
        // 获取线程名
        System.out.println(thread1.getName());
        System.out.println(thread2.getName());
    }

    public static void demo1() {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread(myRunnable,"张三");
        Thread thread2 = new Thread(myRunnable,"李四");
        ThreadGroup threadGroup = thread1.getThreadGroup();
        ThreadGroup threadGroup1 = thread2.getThreadGroup();
        // 默认都是主线程组
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup1.getName());

    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + "....." + i);
        }
    }
}
