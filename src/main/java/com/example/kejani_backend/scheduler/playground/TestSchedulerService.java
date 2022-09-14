package com.example.kejani_backend.scheduler.playground;

import com.example.kejani_backend.scheduler.billInfo.BillInfo;
import com.example.kejani_backend.scheduler.jobs.BillJob;
import com.example.kejani_backend.scheduler.services.SchedulingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestSchedulerService {

    @Autowired
    private final SchedulingService schedulingService;

    public TestSchedulerService(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    public void TestScheduler(){
        final BillInfo billInfo = new BillInfo();
        billInfo.setTotalFireCount(10);
        billInfo.setRepeatInterval(2000);
        billInfo.setInitialOffset(1500);
        billInfo.setCallBackData("Bill CallBackData");
        log.info("Your Bill is up Now");

        schedulingService.runningSchedule(BillJob.class, billInfo);
    }
}
