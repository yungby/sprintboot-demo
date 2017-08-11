package com.example.demo.mq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@RabbitListener(queues = "topic.message")
	public void processMessage (String hello) {
		System.out.println("Receiver msg " + hello);
	}
	@RabbitListener(queues = "topic.messages")
	public void processMessages (String hello) {
		System.out.println("Receiver msgs " + hello);
	}
	
	@RabbitListener(queues = "fanout.A")
	public void fanoutA (String hello) {
		System.out.println("fanoutA msg " + hello);
	}
	@RabbitListener(queues = "fanout.B")
	public void fanoutB (String hello) {
		System.out.println("fanoutB msg " + hello);
	}
	@RabbitListener(queues = "fanout.C")
	public void fanoutC (String hello) {
		System.out.println("fanoutC msg " + hello);
	}
}
