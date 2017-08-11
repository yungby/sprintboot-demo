package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mail.MailServiceImp;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMailTests {

	@Autowired
	private MailServiceImp mailServiceImp;
	
	@Test
	public void testSimpleMailSender(){
		mailServiceImp.sendSimpleMail("yungbyandy@163.com", "springboot-demo test mail sender", "This is test mail send!");
	}
	
}
