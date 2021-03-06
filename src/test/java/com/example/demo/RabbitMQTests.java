package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mq.service.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTests {

	@Autowired
	private HelloSender helloSender;
	@Test
	public void testSendTopicMq() throws InterruptedException {
		
		for (int i = 0; i < 100; i++) {
			helloSender.sendTopicMQMsg();
			Thread.sleep(100);
		}
	}
	
	@Test
	public void testSendFanoutMq() throws InterruptedException {
		
		for (int i = 0; i < 100; i++) {
			helloSender.sendFanoutMQMsg();
			Thread.sleep(100);
		}
	}
	
	
}
