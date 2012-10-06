package com.tradingPlatform.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.tradingPlatform.exceptions.ShareNotFoundException;
import com.tradingPlatform.model.entities.Share;

/**
 * 
 * @author gabriel.higgins
 *
 */
public class ShareController  {	
	
	private List<Share> sharesArray = new ArrayList<Share>();
	
	/***************************************************************************
	 
	 ***************************************************************************/
	
	/**
	 * add new shares to the list without overwriting previous shares.
	 * 
	 * @param share
	 */
	public void addShare(Share share){
		
		if(!sharesArray.isEmpty()){	
			Share newShare = share;
			List<Share> idList = getSharesById(share.getShareId());
			
			int maxIssue = 0;
					
			if(!idList.isEmpty()) {
				Share latest;
				try {
					latest = this.findLatestShareIssueId(idList); //find the latest share issue id
					maxIssue = latest.getShareIssueId();
				} catch (ShareNotFoundException e) {
					maxIssue = 0;
				}			
			}
			newShare.setShareIssueId(maxIssue+1); //set the share id issue to one greater that previous entry
			
			sharesArray.add(newShare);
		}
		else 
			sharesArray.add(share);
	}
	
	/***************************************************************************
	 
	 ***************************************************************************/
	/**
	 * create a new share if only given 2 parameters
	 * 
	 * @param shareId
	 * @param price
	 */
	public void constructNewShare(int shareId, BigDecimal price){
				
		Share newShare = new Share(shareId, price);
		List<Share> idList = getSharesById(newShare.getShareId());
		
		int maxIssue = 0;
				
		if(!idList.isEmpty()) {
			Share latest;
			try {
				latest = this.findLatestShareIssueId(idList); //find the latest share issue id
				maxIssue = latest.getShareIssueId();
			} catch (ShareNotFoundException e) {
				maxIssue = 0;
			}			
		}
		newShare.setShareIssueId(maxIssue+1); //set the share id issue to one greater that previous entry
		
		sharesArray.add(newShare);
	}
		
	
	/***************************************************************************
	  
	 ***************************************************************************/	
	/**
	 * update a share but keep a record of the old share and increment the new share issue id by 1.
	 * 
	 * @param share
	 * @param newPrice
	 */
	public void updateSharePrice(Share share, BigDecimal newPrice){
		
		boolean previouslyUpdated = share.getUpdateFlag();
		
		if(previouslyUpdated){
			System.out.println("Share cannot be updated twice, try another share");
			return;
		}
		
		int shareId = share.getShareId();
		BigDecimal price = newPrice;
		
		
		if(!sharesArray.isEmpty()&& sharesArray.contains(share)){
			Share updatedShare = new Share(shareId, price);
			updatedShare.setShareIssueId(share.getShareIssueId() + 1);
			
				//set updated share update time instance variable
			share.setLastUpdate(new Date(System.currentTimeMillis()));
					
			sharesArray.add(updatedShare);
			share.setUpdateFlag(true);
		}		
		else
			System.out.println("Share does not exist!");
		
	}
	
	/***************************************************************************
	 
	 ***************************************************************************/	
	/**
	 * 
	 * @param shareId
	 */
	public void removeShares(int shareId){
		
		boolean found = true;
		Iterator<Share> it = sharesArray.iterator();
		
		while(it.hasNext()){
			Share s = it.next();

			if(s.getShareId() == shareId){
				it.remove();
				found = false;
			}
		}
		if(found == false)
			System.out.println("Shares removed");
		else if(found == true)
			System.out.println("Shares do not exist!");
		
	}
	
	/***************************************************************************
	 
	 ***************************************************************************/	
	/**
	 * 
	 * @param shareId
	 * @return
	 */
	public ArrayList<Share> getSharesById(int shareId){
		
		ArrayList<Share> shares = new ArrayList<Share>();
		
		if(!sharesArray.isEmpty()){
			for(Share s: sharesArray){
				if(s.getShareId() == shareId){
					shares.add(s);
					
				}
			}
		}
			return shares;
	}
	
	/***************************************************************************
	  
	 ***************************************************************************/	
	/**
	 * return a particular companies latest share value
	 * 
	 * @param shareId
	 * @return
	 * @throws ShareNotFoundException 
	 */
	public Share getMostRecentIssue(int shareId) throws ShareNotFoundException{
		
		ArrayList<Share> sharesList = new ArrayList<Share>();
		
		if(!sharesArray.isEmpty()){
			for(Share s : sharesArray){
				if(s.getShareId() == shareId){
					sharesList.add(s);									
				}
			}
			Share latestShare = findLatestShareIssueId(sharesList);
			return latestShare;
		}
		throw new ShareNotFoundException();
	}
	
	/***************************************************************************
	  
	 ***************************************************************************/		
	/**
	 * return the share with the with the highest share issue id.
	 * 
	 * @param shareList
	 * @return
	 */
	
	private Share findLatestShareIssueId(List<Share> shareList)throws ShareNotFoundException {
		
		Share latest = null;
		
		for(Share s : shareList){
			int shareIssueId = s.getShareIssueId();
			if(latest == null) {
				latest = s;
			} else if (shareIssueId > latest.getShareIssueId()) {
				latest = s;
			}
		}
		if(latest != null)
			return latest;
		else 
			throw new ShareNotFoundException();
	}
	
	/***************************************************************************
	 
	 ***************************************************************************/	
	/**
	 * 
	 * @param price
	 * @return
	 */
	public List<Share> getSharesAbovePrice(BigDecimal price){
		
		ArrayList<Share> highPriceShares = new ArrayList<Share>();
		
		for(Share s : sharesArray){
			if(s.getPrice().compareTo(price)== 1)
				highPriceShares.add(s);			
		}
		return highPriceShares;		
	}
	
	/***************************************************************************
	 
	 ***************************************************************************/	
	/**
	 * 
	 * @return
	 */
	public List<Share> getAllShares(){
		return sharesArray;
	}
	
} 

