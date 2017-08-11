package com.example.demo.mq.service;

import java.time.LocalDateTime;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void sendTopicMQMsg() {
		String text = "topic message " + LocalDateTime.now();
		rabbitTemplate.convertAndSend("exchange", "topic.message", text);
		System.out.println(text);
	}
	
	public void sendFanoutMQMsg() {
		String text = "fanout message " + LocalDateTime.now();
		rabbitTemplate.convertAndSend("fanoutExchange", "", text);
		System.out.println(text);
	}
}
