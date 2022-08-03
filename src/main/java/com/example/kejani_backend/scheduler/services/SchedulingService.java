package com.example.kejani_backend.scheduler.services;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
@Slf4j
@RequiredArgsConstructor
public class SchedulingService {
    //injecting scheduler here
    private final Scheduler scheduler;

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
