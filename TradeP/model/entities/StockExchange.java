package com.tradingPlatform.model.entities;

/**
 * 
 * @author gary.wiseman
 * 
 */

public class StockExchange {

	private int stockExId;
	private String name;
	private String location;


	//Stock Exchange Constructor

	public StockExchange(int stockExId, String name, String location) {


		this.stockExId = stockExId;
		this.name = name;
		this.location = location;

	}

	public int getStockExId() {
		return stockExId;
	}

	public void setStockExId(int stockExId) {
		this.stockExId = stockExId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * 
	 * This method puts all values that are returned into a specific string
	 * order with formatting required.
	 * 
	 */
	public String toString() {

		return "Stock Exchange Id: " + stockExId + "\nName: " + name
				+ "\nLocation: " + location;
	}

}
