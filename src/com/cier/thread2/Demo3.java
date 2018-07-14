package com.cier.thread2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 计时器类在指定时间安排指定任务
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        // 第一个参数是安排的任务，第二个参数是执行的时间点，第三个参数是指过多长时间再次执行这个任务
        timer.schedule(new MyTimerTask(),new Date(118,6,14,10,8,20),3000);
        while (true){
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }


}
class MyTimerTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("起床背英语单词");
    }
}