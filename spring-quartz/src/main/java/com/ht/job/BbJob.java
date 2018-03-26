package com.ht.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BbJob implements Job{
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("fffffffffff");
    }
}
