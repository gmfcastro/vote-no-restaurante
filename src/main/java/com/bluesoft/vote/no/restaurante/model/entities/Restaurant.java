package com.bluesoft.vote.no.restaurante.model.entities;

import javax.persistence.Entity;

@Entity
public class Restaurant extends DefaultEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int votes;
	
	public Restaurant(){}
	
	public Restaurant(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
}
