package com.ss.utopia.entities;

import lombok.Data;

@Data
public class Message {

	Token token;
	String address;
	String link;
	String subject = "Smoothbank Confirmation";
	String body = "Thank you for your interest in our service! Please click the following link to continue the process.";

	public Message(Token token, String recipient, String urlLink) {
		this.setToken(token);
		this.setAddress(recipient);
		this.setLink(urlLink);
	}

}
