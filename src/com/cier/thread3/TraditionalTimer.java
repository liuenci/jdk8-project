package com.cier.thread3;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimer {
    public static int x = 0;
    public static void main(String[] args) {
        /*// 设置一个定时器 3 秒之后执行
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("boom");
            }
        },3000);*/


        /*// 第一次 3 秒之后执行，之后没过一秒循环执行
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("boom");
            }
        },3000,1000);*/
        // 隔两秒执行一次，再隔四秒执行一次
        class MyTimerTask extends TimerTask{
            @Override
            public void run() {
                x = ++x % 2;
                System.out.println("boom");
                new Timer().schedule(new MyTimerTask(){
                    @Override
                    public void run() {
                        super.run();
                    }
                },2000 + 2000 * x);
            }
        }
        new Timer().schedule(new MyTimerTask(),2000);

        while (true) {
            System.out.println( new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}