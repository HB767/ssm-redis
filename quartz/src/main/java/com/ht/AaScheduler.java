package com.ht;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class AaScheduler {

    public static void main(String[] args) {
            try {
                Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
                JobDataMap dataMap = new JobDataMap();
                dataMap.put("money", 100.0);
                JobDetail buyJobDetail = JobBuilder.newJob(AaJob.class)
                        .setJobData(dataMap)
                        .build();
                Trigger buyJobTrigger = TriggerBuilder.newTrigger()
                        .withSchedule(CronScheduleBuilder.cronSchedule("0/5 39 19 * * ? *"))
                        .build();
                scheduler.start();
                scheduler.scheduleJob(buyJobDetail, buyJobTrigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
    }

}
