package com.ss.utopia.entities;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Token<T> {

	//Object the token is generated for
	private T obj;
	//String representation of the token
	private String sequence;
	//Time the token was created
	private Calendar created;
	//Time To Live
	private Integer ttl;
	
	/**
	 * Determines if the Token is still valid by seeing if it's still alive or not
	 * @return True if the time passed since creation is less than the time to live
	 */
	public boolean isAlive() {
		return created.getTime().getTime() - Calendar.getInstance().getTime().getTime() <= ttl;
	}
	
	public void generateSequence() {
		this.sequence = UUID.randomUUID().toString();
	}
	
}
