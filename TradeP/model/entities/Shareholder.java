package com.tradingPlatform.model.entities;

import com.tradingPlatform.model.AccountTypes;

public class Shareholder extends Account{

	public Shareholder(){
		
	}
	public Shareholder(int id, String username, AccountTypes accountType) {
		super(id, username, accountType);
	}
	
}
