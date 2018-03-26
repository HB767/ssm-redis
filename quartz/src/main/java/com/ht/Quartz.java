package com.ht;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz {
    public static void main(String[] args) {
        try {
            //调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            //创建要执行任务的类
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();
            //触发器
            Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5))
                    .build();
            scheduler.start();
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
