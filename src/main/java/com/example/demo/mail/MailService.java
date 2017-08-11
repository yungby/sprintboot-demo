package com.example.demo.mail;

public interface MailService {

	 public void sendSimpleMail(String to, String subject, String content);
	 
	 public void sendAttachmentMail(String to, String subject, String content);
	 
	 
	 public void sendInlineMail(String to, String subject, String content);
	 
	 public void sendTemplatesMail(String to, String subject);
	 
}
