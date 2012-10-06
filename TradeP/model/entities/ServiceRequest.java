package com.tradingPlatform.model.entities;

import java.util.Date;


public class ServiceRequest extends Request{
	
	String description;
	
	public ServiceRequest(int impUserID, int impRequestID, Date impRequestTime, requestStatus impStatus, requestType impType, String impDesc){
		super(impUserID,impRequestTime, impStatus, impType);
	this.description = impDesc;
	}

}
