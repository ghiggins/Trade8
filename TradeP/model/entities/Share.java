package com.tradingPlatform.model.entities;

import java.math.BigDecimal;
import java.util.Date;

public class Share {
	private final int SHAREISSUEID=1;
	
	private int shareId;	
	private BigDecimal price;	
	private Date dateIssued;	
	private Date dateEnded;	
	private Date lastUpdate;
	private boolean updateFlag;

	private int shareIssueId = SHAREISSUEID;	
	
	public Share(int shareId, BigDecimal price){		
		this.shareId= shareId;		
		this.price = price;		
		this.dateIssued=new Date(System.currentTimeMillis());
	}	
	
	public int getShareId() {		
		return shareId;	
	}	
	
	public void setShareId(int shareId) {		
		this.shareId = shareId;	
	}	
	
	public BigDecimal getPrice() {		
		return price;	
	}	
	
	public void setPrice(BigDecimal price) {		
		this.price = price;	
	}	
	
	public Date getDateIssued() {		
		return dateIssued;	
	}	
	
	public void setDateIssued(Date dateIssued) {		
		this.dateIssued = dateIssued;	
	}	
	
	public Date getDateEnded() {		
		return dateEnded;	
	}	
	
	public void setDateEnded(Date tdateEnded) {		
		this.dateEnded = tdateEnded;	
	}	
	
	public Date getLastUpdate(){		
		return lastUpdate;	
	}	
	
	public void setLastUpdate(Date lastUpdate){		
		this.lastUpdate = lastUpdate;	
	}
	
	public boolean getUpdateFlag() {
		return updateFlag;
	}

	public void setUpdateFlag(boolean updateFlag) {
		this.updateFlag = updateFlag;
	}
	
	public int getShareIssueId() {		
		return shareIssueId;	
	}	
	
	public void setShareIssueId(int shareIssueId) {		
		this.shareIssueId = shareIssueId;	
	}
	
	public String toString(){
		if(getLastUpdate() != null){
			return "Share ID: " + getShareId() + "\nPrice: " + getPrice() +
					"\nDate Issued: " + getDateIssued() +  "\nShare Issue ID: " + 
						getShareIssueId() +"\nLast update: " + getLastUpdate() + "\n";
			}
		else{
			return "Share ID: " + getShareId() + "\nPrice: " + getPrice() +
					"\nDate Issued: " + getDateIssued() +  "\nShare Issue ID: " + 
						getShareIssueId()+ "\nLast update:  --------- " + "\n";
			}
	}
} 

