package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mail.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("163")
public class DemoMailTests {

	@Autowired
	private MailService mailService;
	
	@Test
	public void testSimpleMailSender(){
		mailService.sendSimpleMail("yungbyzy@163.com", "springboot-demo test mail sender", "This is test mail send!");
	}
	
}
