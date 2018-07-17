package com.cier.thread3;

/**
 * 传统的两种线程的创建方式
 *
 */
public class TraditionalThread {

    public static void main(String[] args) {
        // 新建线程
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 线程休息 500 毫秒
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 两种方式取得线程的名字
                    System.out.println("1:" + Thread.currentThread().getName());
                    System.out.println("2:" + this.getName());
                }
            }
        };
        // 线程运行
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 线程休息 500 毫秒
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 两种方式取得线程的名字
                    System.out.println("1:" + Thread.currentThread().getName());
                }
            }
        });
        thread2.start();
        /**
         * 会覆盖父类的 run 方法
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 线程休息 500 毫秒
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 两种方式取得线程的名字
                    System.out.println("4:" + Thread.currentThread().getName());
                }
            }
        }) {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 线程休息 500 毫秒
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 两种方式取得线程的名字
                    System.out.println("3:" + Thread.currentThread().getName());
                }
            }
        }.start();
    }
}
