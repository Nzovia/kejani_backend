package com.example.kejani_backend.scheduler.playground;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TestService {
    private static  LocalDate date;
    private int age;

   public void getNewAge(){
       if(date == LocalDate.now() )
       {
           System.out.println("get the birthday");
       }
   }
}
