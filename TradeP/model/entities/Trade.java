package com.tradingPlatform.model.entities;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @author gary.wiseman
 * @version %I%, %G%
 * 
 * 
 * The Trade class is responsible for declaring and constructing the trade parameters which 
 * are then passed to the Trade Controller to be stored in an Array List.
 * 
 */

public class Trade {

	//declaring different enum options
	public enum TradeOptions {
		NONE,
		BUY,
		SELL
	}
	
	TradeOptions type; // Enum type
	private int tradeId;
	private Date date;
	private int transactionId;
	private Date transactionTime;
	private int shareId;
	private int shareQuantity;
	private int brokerId;
	private int shareholderId;
	private int stockExId;
	private BigDecimal pricePerShare;
	private BigDecimal totalPrice;

	//Share Constructor
	public Trade(TradeOptions type, int tradeId, int transactionId, int shareId, 
			int shareQuantity, int brokerId, int shareholderId, int stockExId, BigDecimal pricePerShare)
	{
			
		this.type = type;
		this.tradeId = tradeId;
		this.date = new Date(System.currentTimeMillis());
		this.transactionId = transactionId;
		this.transactionTime = new Date(System.currentTimeMillis()); 
		this.shareId = shareId;
		this.shareQuantity = shareQuantity;
		this.brokerId = brokerId;
		this.shareholderId = shareholderId; 
		this.stockExId = stockExId;
		this.pricePerShare = pricePerShare;
		this.totalPrice = pricePerShare.multiply(new BigDecimal(shareQuantity));
				
	}

	//List of getters and setters
	
	public TradeOptions getType() {
		return type;
	}

	public void setType(TradeOptions type) {
		this.type = type;
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}


	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	
	public int getShareQuantity() {
		return shareQuantity;
	}

	public void setShareQuantity(int shareQuantity) {
		this.shareQuantity = shareQuantity;
	}

	public int getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	public int getStockExId() {
		return stockExId;
	}

	public void setStockExId(int stockExId) {
		this.stockExId = stockExId;
	}

	public int getShareholderId() {
		return shareholderId;
	}
	
	public void setShareholderId(int shareholderId) {
		this.shareholderId = shareholderId;
	}
	
	public BigDecimal getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(BigDecimal pricePerShare) {
		this.pricePerShare = pricePerShare;
	}


	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * 
	 * This method puts all values that are returned into a specific string order with formatting
	 * required.
	 * 
	 */
	public String toString(){
		
		return "Trade type: " + this.type + "\nTrade ID: " + this.tradeId + "\nTransaction Id: " 
				+ this.transactionId + "\nShare Quantity: " + this.shareQuantity + "\nTransaction Time: " 
				+ this.transactionTime + "\nTotal Price: " + this.totalPrice + "\n\n";
	}


}
