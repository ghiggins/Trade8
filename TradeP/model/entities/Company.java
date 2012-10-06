package com.tradingPlatform.model.entities;

public class Company {
	
	
	private int companyID;
	private String name;
	private boolean listed;
	
	public Company(int id,String name,boolean listed){
		this.companyID = id;
		this.name = name;
		this.listed = listed;
	}
	
	
	public void setCompanyID(int id){
		this.companyID = id;
	}
	
	public int getCompanyID(){
		return this.companyID;
	}
	
	public void setCompanyName(String name){
		this.name = name;
	}
	
	public String getCompanyName(){
		return this.name;
	}
	
	public void setListed(boolean listed){
		this.listed = listed;
	}
	
	public boolean getListed(){
		return this.listed;
	}

}
