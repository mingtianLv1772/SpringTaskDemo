package com.lnson.springtask.demo.service.impl;

import com.lnson.springtask.demo.service.TaskDemoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 提供了@Scheduled注解的方法将作为定时任务来执行（在配置文件中需要开启对注解@Scheduled的支持）
 * initialDelay：设置tomcat服务器启动完成后，到多少毫秒之后，开始执行定时任务
 * fixedDelay：任务执行的频度，设置每隔多少毫秒执行一次定时任务
 */
@Service
public class TaskDemoServiceImpl implements TaskDemoService {

    @Scheduled(initialDelay = 1000,fixedDelay = 1000)
    @Override
    public void firstTask() {
        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：第1个定时任务");
    }

    @Scheduled(initialDelay = 2000,fixedDelay = 3000)
    @Override
    public void secondTask() {
        //System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：第2个定时任务");
    }

    /**
     * 每隔5秒执行一次定时任务
     */
    @Scheduled(cron = "*/5 * * * * ?")
    @Override
    public void thirdTask() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：第3个定时任务");
    }

    /**
     * 每天的02:45:00执行一次定时任务
     */
    @Scheduled(cron = "0 45 2 * * ?")
    @Override
    public void fourthTask() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：第4个定时任务");
    }

}
