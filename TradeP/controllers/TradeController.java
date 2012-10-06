package com.tradingPlatform.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.tradingPlatform.exceptions.TradeNotFoundException;
import com.tradingPlatform.model.entities.Trade;
import com.tradingPlatform.model.entities.Trade.TradeOptions;

/***********************
 * 
 * @author gary.wiseman
 * @version %I%, %G%
 * 
 *          The TradeController class is responsible for performing all
 *          operations for the Trade class. Therefore manipulates all data
 *          within the array list that has been generated inside the controller.
 * 
 ***********************/

public class TradeController {

	List<Trade> trades = new ArrayList<Trade>();

	public void addTrade(TradeOptions type, int transactionId, int shareId, 
			int shareQuantity, int brokerId, int shareholderId, int stockExId, BigDecimal pricePerShare) {

		int tradeId=0; 
		
		for(Trade t : trades){
			
			if(t.getTradeId() > tradeId){
				tradeId = t.getTradeId();
			}
			
		}
		Trade trade = new Trade(type, ++tradeId, transactionId, shareId, 
			shareQuantity, brokerId, shareholderId, stockExId, pricePerShare);
		trades.add(trade);
		
		
		
		// String output = trade.toString();
		// System.out.println(output);
		// System.out.println(trades.get(0).getShareQuantity());
	}

	// *****************************************************************************

	/**
	 * 
	 * @param tradeId
	 * 
	 */

	public void removeTrade(int tradeId) {

		for (Trade t : trades) {
			if (t.getTradeId() == tradeId) {
				trades.remove(t);
				System.out.println("Removed trade: \n" + t);
				break;
			} else if (t.equals(trades.size())) {
				System.out.println("Trade does not exist in the array");
			}
		}
	}

	// *****************************************************************************

	/**
	 * 
	 * This method simply returns all of the elements in the array list called
	 * trades.
	 * 
	 */
	public void displayAll() {

		for (Trade t : trades) {
			System.out.println(t.toString());
		}
		System.out.println("End of array");

	}

	// *****************************************************************************

	/**
	 * 
	 * @return trades
	 * 
	 *         This method retrieves all trades from the array list.
	 * 
	 */
	public List<Trade> getAllTrades() {

		return trades;
	}

	// ****************************************************************************

	/**
	 * 
	 * @param tradeId
	 * @return tradeById
	 * @throws TradeNotFoundException
	 * 
	 *             This method will get all trades from the original array list
	 *             that match the tradeId parameter that has been entered by the
	 *             user. Each element found is then stored in a new array list
	 *             and then returned back to the main class.
	 * 
	 */
	public Trade getTradeById(int tradeId) throws TradeNotFoundException {

		for (Trade t : trades) {
			if (t.getTradeId() == tradeId) {
				return t;
			}
		}

		throw new TradeNotFoundException();
	}

	// ***************************************************************************

	/**
	 * 
	 * @param transactionId
	 * @return transactionsById
	 * @throws TradeNotFoundException
	 * 
	 *             This method is called to retrieve all specified trades that
	 *             have a common transaction id. It iterates through each of the
	 *             elements in the trades list and if nothing is found then an
	 *             exception is thrown.
	 * 
	 */

	public List<Trade> getTradesByTransactionId(int transactionId)
			throws TradeNotFoundException {

		List<Trade> transactionsById = new ArrayList<Trade>();
		for (Trade t : trades) {
			if (t.getTransactionId() == transactionId) {
				transactionsById.add(t);
				System.out.println(t.toString());
			}
		}
		if (transactionsById.isEmpty()) {
			throw new TradeNotFoundException();
		}
		return transactionsById;
	}

	// ***************************************************************************

}
