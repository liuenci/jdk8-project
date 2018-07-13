package com.cier.threadmethod;

/**
 * 设置线程名字的两种方式
 */
public class Demo1 {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                // this.setName("张三");
                System.out.println(this.getName() + " AA");
            }
        };

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                // this.setName("李四");
                System.out.println(this.getName() + " BB");
            }
        };

        thread.setName("张三");
        thread1.setName("李四");
        thread.start();
        thread1.start();
    }
    /**
     * 通过构造方法给 name 赋值
     */
    public static void demo1() {
        new Thread("芙蓉姐姐"){
            @Override
            public void run() {
                System.out.println(this.getName() + " BB");
            }
        }.start();

        new Thread("凤姐"){
            @Override
            public void run() {
                System.out.println(this.getName() +" AA");
            }
        }.start();
    }
}
