package com.example.kejani_backend.scheduler.billInfo;
import lombok.Data;

@Data //it bundles @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor ...
public class BillInfo {
    //the class has all the information that is used for the configurations (properties) of the scheduler
    //it tells the scheduler when, and the span of the scheduled jobs

    private int totalFireCount;
    private boolean runForever; //if true the  scheduler runs forever , no county
    private long repeatInterval; //the interval in which the scheduler will repeat execution
    private  long initialOffset; //when timer fires the first time
    private String callBackData;  //this is the data that we want to pass to our job, when we call the timer we can store some data with it




}
