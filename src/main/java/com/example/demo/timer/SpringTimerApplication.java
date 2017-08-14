package com.example.demo.timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringTimerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApplication.class, args);
	}

}
