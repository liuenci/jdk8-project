package com.cier.thread3;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadScopeShareData {
    public static int data = 0;
    public static Map<Thread,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + " has put data = " + data);
                    map.put(Thread.currentThread(),data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A {
        public void get() {
            System.out.println("A from " + Thread.currentThread().getName() + " get data = " + map.get(Thread.currentThread()));
        }
    }

    static class B {
        public void get() {
            System.out.println("B from " + Thread.currentThread().getName() + " get data = " + map.get(Thread.currentThread()));
        }
    }

}
