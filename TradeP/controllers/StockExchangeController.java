package com.tradingPlatform.controllers;

import java.util.ArrayList;
import java.util.List;

import com.tradingPlatform.exceptions.ExchangeNotFoundException;
import com.tradingPlatform.model.entities.StockExchange;

/***********************
 * 
 * @author gary.wiseman
 * @version %I%, %G%
 * 
 * The StockExchangeController is responsible for performing all operations on the array list
 * of type Stock Exchange. 
 * 
 **********************/

public class StockExchangeController {

	List<StockExchange> stockExchanges = new ArrayList<StockExchange>();

	// ******************************************************************************************

	public void addStockExchange(String name, String location) {

		int newStockExId = 0;

		for (StockExchange st : stockExchanges) {
			if (st.getStockExId() > newStockExId) {

				newStockExId = st.getStockExId();
			}
		}

		StockExchange stockExchange = new StockExchange(++newStockExId, name,
				location);
		stockExchanges.add(stockExchange);
		// System.out.println(stockExchanges.toString());
		// System.out.println(trades.get(0).getShareQuantity());

	}

	// *****************************************************************************************

	public void displayAllExchanges() {

		for (StockExchange st : stockExchanges) {

			System.out.println(st.toString());
		}
		System.out.println("Reached end of array");

	}

	// ****************************************************************************************
	public StockExchange getStockExchangeByID(int stockExId)throws ExchangeNotFoundException {
		
		
		for (StockExchange st : stockExchanges) {
			if (st.getStockExId() == stockExId) {
				//System.out.println(st.toString());
				return st;
				
			}
		}

		throw new ExchangeNotFoundException();
		
	}
	
	//*****************************************************************************************
	public List <StockExchange> getAllStockExchanges(){
		
		return stockExchanges;
	}
	
	//*****************************************************************************************

}
