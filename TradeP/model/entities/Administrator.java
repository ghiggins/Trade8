package com.tradingPlatform.model.entities;

import com.tradingPlatform.model.AccountTypes;


public class Administrator extends Account {

	public Administrator(){
		
	}
	
	public Administrator(int id, String username, AccountTypes accountType) {
		super(id, username, accountType);
	}

}
