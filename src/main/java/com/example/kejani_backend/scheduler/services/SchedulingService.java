package com.example.kejani_backend.scheduler.services;
import com.example.kejani_backend.scheduler.billInfo.BillInfo;
import com.example.kejani_backend.scheduler.utils.BillUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Slf4j
@Service
public class SchedulingService {
    //injecting scheduler here
    private final Scheduler scheduler;

    @Autowired
    public SchedulingService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    //scheduling job method-> this only happens when a job and a Trigger are ready
        public void runningSchedule(final Class jobClass, final BillInfo billInfo){
            final JobDetail jobDetail = BillUtils.buildJobDetails(jobClass, billInfo);
            final Trigger trigger = BillUtils.buildTrigger(jobClass, billInfo);

            try{
                scheduler.scheduleJob(jobDetail, trigger);
            }catch (SchedulerException e){
                log.error(e.getMessage(), e);
            }
        }

    //to be able to schedule a job you need to start the scheduler,
    // when you stop the job then shutdown the scheduler
    @PostConstruct
    public void startScheduler(){
        try{
            scheduler.start();;
        }
        catch (SchedulerException exception){
            log.error(exception.getMessage(), exception);
        }
    }

    @PreDestroy
    public void shutdownScheduler(){
        try{
            scheduler.shutdown();
        }
        catch (SchedulerException e){
            log.error(e.getMessage(),e);
        }
    }
}
