package com.app.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.service.emailService;

@Controller
@Service
@RequestMapping("/email")
public class emailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private emailService eService;

	@GetMapping("/sendEmail")
	public String SendEmail(@RequestParam String toEmail, @RequestParam String body,RedirectAttributes map) {
//	{String body1="<b>Amar Gadekar</b><br>Solapur MAngalwedha";
//		System.out.println("email controller to Email:"+toEmail+" body:"+body);
//		
//		//SimpleMailMessage message=new SimpleMailMessage();
//		MimeMessage message=mailSender.createMimeMessage();
//		MimeMessageHelper message1=new MimeMessageHelper(message);
//		message1.setFrom("amargadekar33@gmail.com");
//		message1.setTo(toEmail);
//		message1.setText(body,true);
//		message1.setSubject(subject);
//		mailSender.send(message);
//		
//		System.out.println(message);
		
		System.out.println("mail sent");
		String subject = "Dairy Bill";
		boolean flag;
		try {
			flag = eService.SendEmail(toEmail, body, subject);
			if (flag) {
				map.addFlashAttribute("emailMsg", "Mail  Sent sucessfully");
				return   "redirect:/customer/bill" ;
			} 
			else {
				map.addFlashAttribute("emailMsg", "Mail not Sent sucessfully");
				return   "redirect:/customer/bill" ;
          
			}
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.addFlashAttribute("emailMsg", "Mail not Sent sucessfully");
			return   "/admin/home";
		}

	}

}
