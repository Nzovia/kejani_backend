package com.example.kejani_backend.scheduler.playground;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/vi/scheduler")
public class TestController {
    private final TestSchedulerService testScheduler;

    @PostMapping("/runBill")
    public void triggerScheduler(){
        testScheduler.TestScheduler();
    }
}
