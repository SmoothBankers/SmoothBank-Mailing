package com.ss.sbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.sbank.dao.TokenDAO;
import com.ss.sbank.entities.Token;

@Service
public class TokenService {
	
	@Autowired
	TokenDAO tDAO;
	
	public Token getToken(String seq) {
		return tDAO.getBySequence(seq);
	}

}
