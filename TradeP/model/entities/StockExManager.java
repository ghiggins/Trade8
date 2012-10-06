package com.tradingPlatform.model.entities;

import com.tradingPlatform.model.AccountTypes;

public class StockExManager extends Account{

	public StockExManager(){
		
	}
	public StockExManager(int id, String username, AccountTypes accountType) {
		super(id, username, accountType);
	}

}
