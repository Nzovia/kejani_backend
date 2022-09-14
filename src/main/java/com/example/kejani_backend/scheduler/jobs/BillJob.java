package com.example.kejani_backend.scheduler.jobs;

import com.example.kejani_backend.scheduler.billInfo.BillInfo;
import com.example.kejani_backend.scheduler.playground.TestService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BillJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       // log.info("bill job");  // --> Pass the billing class or service to be scheduled

        //get the callback data
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        BillInfo billInfo = (BillInfo) jobDataMap.get(BillJob.class.getSimpleName());
        log.info(billInfo.getCallBackData());

    }
}
