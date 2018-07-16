package com.cier.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * FutureTask 用于异步获取执行结果，或者取消执行任务的场景。
 * 当一个任务需要执行很长时间，那么就可以通过 FutureTask 来封装这个任务
 * 主线程在完成自己的任务之后再去获取结果
 */
public class Demo4_FutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(1000);
                    result += i;
                }
                return result;
            }
        });
        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        System.out.println(futureTask.get());
    }
}
