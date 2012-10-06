package com.tradingPlatform.model.entities;

import java.util.Date;

import com.tradingPlatform.model.AccountTypes;
import com.tradingPlatform.model.entities.Request.requestStatus;
import com.tradingPlatform.model.entities.Request.requestType;

public class CreateAccountReq extends Request 	{
	
	Account RequestedAccount;     //These vars are responcible for creating the new account parameters.
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String email;
	private AccountTypes accountType;

public CreateAccountReq(int impUserID, Date impRequestTime,
		requestStatus impStatus, requestType impType, String impFirst_Name,
		String impLast_Name, String impUsername, String impPassword, String impEmail,
		AccountTypes impAccountType)
{
	super(impUserID,impRequestTime, impStatus, impType);
	this.first_name = impFirst_Name;
	this.last_name = impLast_Name;
	this.username = impUsername;
	this.password = impPassword;
	this.email = impEmail;
	this.accountType = impAccountType;
}

	
}
