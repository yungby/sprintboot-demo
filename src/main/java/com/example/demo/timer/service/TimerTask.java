package com.example.demo.timer.service;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimerTask {

//	@Scheduled(cron="*/6 * * * * ?")
	public void timeTask1(){
		System.out.println("timeTask1 " + LocalTime.now());
	}
	
//	@Scheduled(fixedRate = 5000)
	public void timeTask2(){
		System.out.println("timeTask2 " + LocalTime.now());
	}
	
//	@Scheduled(initialDelay=2000, fixedRate=8000) 
	public void timeTask3(){
		System.out.println("timeTask3 " + LocalTime.now());
	}
}
