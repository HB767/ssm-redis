package com.ht.scheduler;

import com.ht.job.AaJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class AaScheduler {

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(AaJob.class)
                .withIdentity("aaJob","aaGroup")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("aaTrigger","aaGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * * * ? *"))
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}
