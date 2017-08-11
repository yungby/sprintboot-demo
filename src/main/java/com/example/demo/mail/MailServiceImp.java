package com.example.demo.mail;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class MailServiceImp implements MailService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${mail.fromMail.addr}")
    private String from; 
	
	@Autowired
	private JavaMailSender mailSender;
	@Autowired  
	private Configuration freemarkConfig;	
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

	@Override
	public void sendAttachmentMail(String to, String subject, String content) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content);
			File file = new File("D:\\yungby\\ojdbc6.jar");
			helper.addAttachment(file.getName(), file);
			mailSender.send(mimeMessage);
			log.info("send attachment mail success !");
		} catch (MessagingException e) {
			log.info("send attachment mail failure !");
			e.printStackTrace();
		}
	}

	@Override
	public void sendInlineMail(String to, String subject, String content) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			String text = content +"<body>这是图片：<img src='cid:head' /></body>";
		    helper.setText(text, true);
		    helper.addInline("head", new File("d:\\无标题.jpg"));
			mailSender.send(mimeMessage);
			log.info("send inline mail success !");
		} catch (MailException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			log.info("send inline mail failure !");
			e.printStackTrace();
		}
		
	}

	@Override
	public void sendTemplatesMail(String to, String subject) {
		try {
			Map<String,Object> mailMap = new HashMap<String,Object>();
			mailMap.put("username", "张三  " + LocalDateTime.now());
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			Template template = freemarkConfig.getTemplate("email.ftl");
			String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, mailMap);
			helper.setText(text, true);
			mailSender.send(mimeMessage);
			log.info("send templates mail success !");
		} catch (MessagingException e) {
			log.info("send templates mail failure !");
			e.printStackTrace();
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();    
		}
	}

}
