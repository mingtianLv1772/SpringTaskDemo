package com.lnson.simple.timer.demo;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * java.util.Timer类的使用
 *
 * 只执行一次
 * ==========
 * public void schedule(TimerTask task, long delay);
 *
 * public void schedule(TimerTask task, Date time);
 *
 */
public class TimerDemo1 {

    public static void main(String[] args) {

        Timer timer = new Timer();

        test1(timer);

        test2(timer);

    }

    //只执行一次
    //延迟1000ms执行程序
    public static void test1(Timer timer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, 1000);
    }

    //只执行一次
    //延迟3000ms执行程序
    public static void test2(Timer timer) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("IMP 当前时间" + this.scheduledExecutionTime());
            }
        }, new Date(System.currentTimeMillis() + 3000));
    }

}
