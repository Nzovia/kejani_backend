package com.example.kejani_backend.scheduler.utils;

import com.example.kejani_backend.scheduler.billInfo.BillInfo;
import org.quartz.*;

import java.util.Date;

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

    /*
    * Trigger method -> a mechanism that triggers the job that we wanna do*/
    public static Trigger buildTrigger(final  Class jobClass, final BillInfo info ){
        SimpleScheduleBuilder builder= SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(info.getRepeatInterval());

        if(info.isRunForever()){
            builder.repeatForever();
        }else{
            builder = builder.withRepeatCount(info.getTotalFireCount()-1);
        }
        return TriggerBuilder
                .newTrigger()
                .withIdentity(jobClass.getSimpleName())
                .withSchedule(builder)
                .startAt(new Date(System.currentTimeMillis()+info.getInitialOffset()))
                .build();
    }
}
