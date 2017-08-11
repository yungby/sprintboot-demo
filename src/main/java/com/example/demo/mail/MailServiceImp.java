package com.example.demo.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailServiceImp implements MailService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${mail.fromMail.addr}")
    private String from; 
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage  simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(from);
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		
		try {
			mailSender.send(simpleMailMessage);
			log.info("send simple mail success!");
		} catch (MailException e) {
			log.info("send simple mail failure!");
			e.printStackTrace();
		}
	}

}
