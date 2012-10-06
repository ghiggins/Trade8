package com.tradingPlatform.model.entities;
import java.util.Date;


/**
 * The Request class will be used alot, since alot of Request
 * objects will be created. It stores all of the data of the request
 * in question, also storing the userIDs, for good bookkeeping.
 * @author alexander.evans2
 *
 */
public class Request {
	
	// OK this is the request class, 
	// There might be some thoughts here: As in
	// do we need the status in constr (Since every 
	// request is 'new' at the beginning..)
	
	/**
	 * These enums will store the types of requests. This
	 * is important for later being able to sort them.
	 * @author alexander.evans2
	 *
	 */
	public enum requestType {
		CHANGEPASSWORD, CREATEACCOUNT, SERVICE
		}
	
	
	
	/**
	 * These enums are the requestStatus, which will 
	 * store the status of a request, which is important for 
	 * later finding out on what stage the request is.
	 * @author alexander.evans2
	 *
	 */
	public enum requestStatus {
		NEW, INPROGRESS, COMPLETE
		}

	
	
	private int requestID;
	private int userID;
	private Date requestTime;
	private requestStatus status;
	private requestType type;
	
	
	public Request(int impUserID, Date impRequestTime, requestStatus impStatus, requestType impType){
		this.requestTime = impRequestTime;
		this.status = impStatus;
		this.type = impType;
		this.userID = impUserID;
	}
	
	
	
	/**
	 * This method will return the requestID variable
	 * @return
	 */
	public int getRequestID(){
		return this.requestID;
	}
	
	
	/**
	 * This Method will set the RequestID to the parsed parameter 'i'
	 * @param i
	 */
	public void setRequestID(int i)
	{
		this.requestID = i;
	}
	
	
	/**
	 * This Method will return the requestTime variable
	 * @return
	 */
	public Date getRequestTime(){
		return this.requestTime;
	}
	
	
	/**
	 * this method will set the requestTime to the parsed parameter 'd'
	 * @param d
	 */
	public void setRequestTime(Date d){
		this.requestTime = d;
	}
	
	public requestStatus getRequestStatus(){
		return this.status;
	}
	
	
	/**
	 * this method will set the requestStatus to the parsed parameter '2'
	 * @param d
	 */
	public void setRequestStatus(requestStatus s){
		this.status = s;
	}
	
	
	/**
	 * this method will return the type variable
	 * @param d
	 */
	public requestType getRequestType(){
		return this.type;
	}
	
	
	/**
	 * this method will set the requestType to the parsed parameter 't'
	 * @param d
	 */
	public void setRequestType(requestType t){
		this.type = t;
	}
	
	
	/**
	 * this method will return the userID variable
	 * @param d
	 */
	public int getUserID(){
		return this.userID;
	}
	
	
	/**
	 * this method will set the userID to the parsed parameter 'id'
	 * @param d
	 */
	public void setUserID(int id){
		this.userID = id;
	}
	
	@Override 
	
	public String toString(){
		return " requestID = " + this.requestID + " requestTime = " + this.requestTime
				+ " status = " + this.status + " type = " + this.type + " userID = " + this.userID;
	}
}
