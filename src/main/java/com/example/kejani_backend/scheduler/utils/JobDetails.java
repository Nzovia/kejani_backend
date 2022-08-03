package com.example.kejani_backend.scheduler.utils;

import com.example.kejani_backend.scheduler.billInfo.BillInfo;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;

public final class JobDetails {
    public JobDetails() {}

    //built job details that will be stored together when we are scheduling a timer
    /*
    * job class-> which class do you want to store this details for
    * */
    public static JobDetail buildJobDetails(final Class jobClass, final BillInfo info){
        final JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put(jobClass.getSimpleName(), info);

        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getSimpleName())
                .setJobData(jobDataMap)
                .build();

    }
}
