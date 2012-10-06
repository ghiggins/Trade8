package com.tradingPlatform.model.entities;

import java.util.Date;


public class PasswordResetReq extends Request {
	
	private String newPassword;
	
	
	public PasswordResetReq(int impUserID, int impRequestID, Date impRequestTime, requestStatus impStatus, requestType impType, String impPassword){
		super(impUserID, impRequestTime, impStatus, impType);
	this.newPassword = impPassword;
	}

}
