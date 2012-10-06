package com.tradingPlatform.controllers;

import java.util.List;
import com.tradingPlatform.model.AccountTypes;
import com.tradingPlatform.model.AccountUtil;
import com.tradingPlatform.model.entities.Account;

public class AccountController {
	
	AccountUtil accUtil = new AccountUtil();
	
	public void addAccount(Account account){
		accUtil.addAccount(account);
	}
	
	public void removeAccountById(int id){
		accUtil.removeAccountById(id);
	}
	
	public Account findAccountById(int id){
		return accUtil.findAccountById(id);
	}
	
	public List<Account> findAccountByFirstName(String firstName){
		return accUtil.findAccountByFirstName(firstName);
	}
	
	public List<Account> findAccountByLastName(String lastName){
		return accUtil.findAccountByLastName(lastName);
	}
	
	public List<Account> findAccountByType(AccountTypes accType){
		return accUtil.findAccountByType(accType);
	}
	
	public void banAccountById(int id){
		//TODO implement
	}
	
	public List<Account> getAccounts(){
		return accUtil.getAccounts();
	}
}
