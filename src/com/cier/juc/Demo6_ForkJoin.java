package com.cier.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Demo6_ForkJoin extends RecursiveTask<Integer>{
    private final int threhold = 5;
    private int first;
    private int last;

    public Demo6_ForkJoin(int first, int last) {
        this.first = first;
        this.last = last;
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo6_ForkJoin demo6_forkJoin = new Demo6_ForkJoin(1,10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(demo6_forkJoin);
        System.out.println(result.get());
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (last - first <= threhold) {
            // 任务足够小则直接计算
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            // 拆分成小任务
            int middle = first + (last - first) / 2;
            Demo6_ForkJoin leftTask = new Demo6_ForkJoin(first,middle);
            Demo6_ForkJoin rightTask = new Demo6_ForkJoin(middle + 1,last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }
        return result;
    }
}
