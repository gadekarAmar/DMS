package com.app.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Service

public class emailService {
	
	@Autowired
	private JavaMailSender mailSender;

	public boolean SendEmail( String  toEmail,  String body,String subject) throws MessagingException
	{
		try {
			String body1="<b>Amar Gadekar</b><br>Solapur MAngalwedha";
			System.out.println("email service to Email:"+toEmail+" body:"+body);
			String editedBody="<b>OTP:</b>"+body;
			//SimpleMailMessage message=new SimpleMailMessage();
			MimeMessage message=mailSender.createMimeMessage();
			MimeMessageHelper message1=new MimeMessageHelper(message);
			message1.setFrom("amargadekar33@gmail.com");
			message1.setTo(toEmail);
			message1.setText(editedBody,true);
			message1.setSubject(subject);
			mailSender.send(message);
			
			System.out.println(message);
			System.out.println("mail sent");
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
