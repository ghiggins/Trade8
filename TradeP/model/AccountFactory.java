package com.tradingPlatform.model;

import com.tradingPlatform.model.entities.Account;
import com.tradingPlatform.model.entities.Administrator;
import com.tradingPlatform.model.entities.Broker;
import com.tradingPlatform.model.entities.Shareholder;
import com.tradingPlatform.model.entities.StockExManager;

public class AccountFactory {
	
	public Account getAccountInstance(Account account){
		
		if(account.getClass().getName().equals("com.tradingPlatform.model.entities.Broker")){
			return new Broker();
		}
		if(account.getClass().getName().equals("com.tradingPlatform.model.entities.Administrator")){
			return new Administrator();
		}
		if(account.getClass().getName().equals("com.tradingPlatform.model.entities.Shareholder")){
			return new Shareholder();
		}
		if(account.getClass().getName().equals("com.tradingPlatform.model.entities.StockExManager")){
			return new StockExManager();
		}
		return null;
	}
}
