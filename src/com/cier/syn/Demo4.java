package com.cier.syn;

/**
 * 火车站卖票的例子实现 Runable 接口
 */
public class Demo4 {

    public static void main(String[] args) {
        MyTicket myTicket = new MyTicket();
        new Thread(myTicket).start();
        new Thread(myTicket).start();
        new Thread(myTicket).start();
        new Thread(myTicket).start();

        // 多次启动一个线程是非法的
        /*Thread thread = new Thread(myTicket);
        thread.start();
        thread.start();
        thread.start();
        thread.start();*/

    }
}

class MyTicket implements Runnable {
    // 这里可以不用使用 static 修饰
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
            // 也可以传入 this
            synchronized (MyTicket.class) {
                if (tickets == 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "这是第" + tickets-- + "号票");
            }
        }
    }
}