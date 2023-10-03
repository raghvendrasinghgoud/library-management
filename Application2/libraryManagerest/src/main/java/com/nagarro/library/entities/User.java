package com.nagarro.library.entities;



import javax.persistence.*;

@Entity	
public class User {
	@Id
	private String username;
	private String fullName;
	private String password;
	/**
	 * @param fullName
	 * @param username
	 * @param password
	 */
	public User(String fullName, String username, String password) {
		super();
		this.fullName = fullName;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * 
	 */
	public User() {
		super();
	}

	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
