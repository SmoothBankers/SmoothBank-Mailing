package com.ss.sbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.TokenDAO;
import com.ss.sbank.entities.Message;
import com.ss.sbank.entities.Token;

@Service
public class MessageService {

	// Used to comment or uncomment all common debug lines. Not technically optimal
	// as it adds extra lines of non-logic code, but it does make things easier
	boolean debug = false;

	@Autowired
	TokenDAO tdao;

	@Autowired
	JavaMailSender mailSender;

	public void sendMessage(Message message) {
		// First, see if the token is in the database already and, if not, save it
		boolean exists = tdao.existsById(message.getToken().getSequence());
		if (debug)
			System.out.println("Token exists? " + exists);

		if (!exists) {
			Token t = message.getToken();
			if (debug)
				System.out.println("retrieved message's token");

			tdao.saveAndFlush(t);
			if (debug)
				System.out.println("Saved token");
		}

		// Construct the email
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(message.getAddress());
		email.setSubject(message.getSubject());
		email.setText(message.getBody() + "\n" + message.getLink() + message.getToken().getSequence());
		email.setFrom("noreply@smoothbank.com");

		// Prepare the mail sender

		System.out.println("*********Attempting to send mail**************");
		try {
			mailSender.send(email);
		} catch (MailException e) {
			System.err.println("Critical mail failure (MessageService line: 38");
			e.printStackTrace();
		}

	}

}
