package com.tradingPlatform.model.entities;

import com.tradingPlatform.model.AccountTypes;

public class Broker extends Account {
	
	public Broker(){
		
	}
	public Broker(int id, String username, AccountTypes accountType) {
		super(id, username, accountType);
	}
	
}
