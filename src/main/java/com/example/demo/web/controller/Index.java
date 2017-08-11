package com.example.demo.web.controller;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {
	
	@Value("${com.neo.title}")
	public String title;
	@Value("${com.neo.description}")
	public String description;
	
	@RequestMapping("/test")
	public String  testHelloWord() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(title + "  " + description);
		return "Hello Word ! " + localDateTime + " " + title + "  " + description;
	}
}
