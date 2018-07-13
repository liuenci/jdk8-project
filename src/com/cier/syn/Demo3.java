package com.cier.syn;

public class Demo3 {
    public static void main(String[] args) {
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
        new Ticket().start();
    }

}

class Ticket extends Thread {
    private static int ticket = 100;
    private static Object object = new Object();
    @Override
    public void run() {
        while (true) {
            // 也可以是 Ticket.class
            synchronized(object){
                if (ticket == 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "这是第" + ticket-- + "号票");
            }
        }
    }
}