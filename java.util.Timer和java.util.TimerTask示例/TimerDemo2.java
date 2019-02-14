package com.lnson.simple.timer.demo;

import java.util.Timer;
import java.util.TimerTask;

/**
 * java.util.Timer类的使用
 *
 * 循环执行
 * ========
 * public void schedule(TimerTask task, long delay, long period);
 *
 * public void scheduleAtFixedRate(TimerTask task, long delay, long period);
 *
 */
public class TimerDemo2 {

    public static void main(String[] args) {

        Timer timer = new Timer();

        //test1(timer);

        test2(timer);

    }

    //前一次执行程序结束后 2000ms 后开始执行下一次程序
    public static void test1(Timer timer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 0, 2000);
    }

    //前一次程序执行开始 后 2000ms后开始执行下一次程序
    public static void test2(Timer timer) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 0, 2000);
    }

}
