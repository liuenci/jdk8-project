package com.cier.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo7_Executors {

    public static void main(String[] args) {
        // 线程池中放入两条线程
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(new MyRunnable());
        service.submit(new MyRunnable());
        // 关闭线程池
        service.shutdown();
    }
}
