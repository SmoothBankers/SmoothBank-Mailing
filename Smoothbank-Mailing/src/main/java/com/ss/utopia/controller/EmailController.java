package com.ss.utopia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email/TEST")
public class EmailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@GetMapping
	public void notifyByEmail() {
		System.out.println("Sending email......");
		SimpleMailMessage msg = new SimpleMailMessage();
		
		/**
		 * TODO: Finish setting up an email that will be used for both sending and receiving test emails
		 */
		msg.setTo("parker.williams@smoothstack.com");
		msg.setSubject("Test of the email notification system");
		msg.setText("This email is a test of the email notification system. If you received this email and are not one of"
				+ " the developers, please send us an email to let us know.");
		
		javaMailSender.send(msg);
		System.out.println("Email sent!");
	}

}
