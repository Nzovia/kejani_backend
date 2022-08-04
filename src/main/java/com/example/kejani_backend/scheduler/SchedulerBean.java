package com.example.kejani_backend.scheduler;
import org.quartz.Scheduler;
        import org.quartz.SchedulerException;
        import org.quartz.impl.StdSchedulerFactory;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerBean {

    @Bean
    public Scheduler getScheduler() throws SchedulerException {
        return StdSchedulerFactory.getDefaultScheduler();
    }

}