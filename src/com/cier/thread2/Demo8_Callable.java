package com.cier.thread2;

import java.util.concurrent.*;

public class Demo8_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 线程池中放入两条线程
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = service.submit(new MyCallable(100));
        Future<Integer> future2 = service.submit(new MyCallable(10));

        System.out.println(future1.get());
        System.out.println(future2.get());
        // 关闭线程池
        service.shutdown();
    }
}

class MyCallable implements Callable<Integer>{
    private int num;
    public MyCallable(int num){
        this.num = num;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <=num; i++){
            sum +=i;
        }
        return sum;
    }
}
