package com.nagarro.library.entities;

import javax.persistence.*;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int aid;
	private String name;
	
	public Author() {
		super();
	}

	public Author(int aid, String name) {
		super();
		this.aid = aid;
		this.name = name;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [aid=" + aid + ", name=" + name + "]";
	}
	
}
