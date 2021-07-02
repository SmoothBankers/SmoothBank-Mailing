package com.ss.sbank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.sbank.entities.Token;

public interface TokenDAO extends JpaRepository<Token, String>{

	
	public Token getBySequence(String seq);
	
}
