package com.ss.utopia.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.utopia.entities.Token;

public interface TokenDAO extends JpaRepository<Token, String>{

}
