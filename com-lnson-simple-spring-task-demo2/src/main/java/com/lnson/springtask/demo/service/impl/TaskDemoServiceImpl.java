package com.lnson.springtask.demo.service.impl;

import com.lnson.springtask.demo.service.TaskDemoService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskDemoServiceImpl implements TaskDemoService {

    @Override
    public void firstTask() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：第1个定时任务");
    }

    @Override
    public void secondTask() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "：第2个定时任务");
    }

}
