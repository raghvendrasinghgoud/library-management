package com.nagarro.library.entities;

import java.time.LocalDate;


import javax.persistence.*;

@Entity
public class Book{

	@Id
	private int code;
	private String name;
	@ManyToOne
	private Author author;
	//@Temporal(TemporalType.DATE)
	private LocalDate addedOn;
	public Book() {
		super();
	}
	public Book(int code, String name, Author author, LocalDate addedOn) {
		super();
		this.code = code;
		this.name = name;
		this.author = author;
		this.addedOn = addedOn;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public LocalDate getAddedOn() {
		return addedOn;
	}
	public void setAddedOn(LocalDate addedOn) {
		this.addedOn = addedOn;
	}
	@Override
	public String toString() {
		return "Book [code=" + code + ", name=" + name + ", author=" + author + ", addedOn=" + addedOn + "]";
	}
//	@Override
//	public Date convertToDatabaseColumn(LocalDate attribute) {
//		return attribute == null ? null : Date.valueOf(attribute);
//	}
//	@Override
//	public LocalDate convertToEntityAttribute(Date dbData) {
//		return dbData == null ? null : dbData.toLocalDate();
//	}
	
}
