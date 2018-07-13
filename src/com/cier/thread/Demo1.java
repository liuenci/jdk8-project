package com.cier.thread;

/**
 * 证明 jvm 是多线程的
 */
public class Demo1 {
    /**
     * 垃圾回收线程和主线程交替执行
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0 ; i < 1000000; i++){
            new Demo();
        }
        for (int i = 0 ; i < 1000000; i++){
            System.out.println("主线程执行代码");
        }

    }
}

class Demo{
    @Override
    protected void finalize() throws Throwable {

        System.out.println("垃圾被清扫了");
    }
}
