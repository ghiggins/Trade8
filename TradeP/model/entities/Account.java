package com.tradingPlatform.model.entities;

import com.tradingPlatform.model.AccountTypes;

public abstract class Account {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private AccountTypes accountType;
	
	public Account(){
		
	}
	
	public Account(int id, String firstName, AccountTypes accountType){
		this.id = id;
		this.firstName = firstName;
		this.accountType = accountType;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AccountTypes getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountTypes accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[ id: " + id + ", username: " + username + ", firstName: " + firstName + ", lastName: " + lastName + ", password: " + password + ", email: " + email +" ]");
		return sb.toString();
	}
}
