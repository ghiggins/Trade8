package com.tradingPlatform.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.tradingPlatform.exceptions.RequestNotFoundException;
import com.tradingPlatform.model.entities.Request;

/**
 * This class is the RequestController, It will 'control' or manage all of the
 * requests and store them as such within its arrayList.
 * 
 * @author alexander.evans2
 * 
 */

public class RequestController {
	/**
	 * This is the array list that will store all of the Requests.
	 */
	List<Request> requests = new ArrayList<Request>();

	/**
	 * This method will take in a Type and return a List of Requests of the same
	 * date. It takes a requestType 'type'as parameter.
	 * 
	 * @param type
	 * @return
	 */
	public List<Request> getRequestsByType(Request.requestType type) {

		List<Request> foundRequests = new ArrayList<Request>();
		for (Request r : requests) {
			if (r.getRequestType() == type) { // For luke.
				foundRequests.add(r);
			}
		}
		return foundRequests;
	}

	/**
	 * This method will take in a enum, which will then loop through existing
	 * requests and pull them out to an array.
	 * 
	 * @param status
	 * @return
	 */
	public List<Request> getRequestsByStatus(Request.requestStatus status) {
		List<Request> foundRequests = new ArrayList<Request>();
		for (Request r : requests) {
			if (r.getRequestStatus() == status) { // For luke.
				foundRequests.add(r);
			}
		}
		return foundRequests;
	}

	/**
	 * returns all requests.
	 * 
	 * @return
	 */
	public List<Request> getAllRequests() {
		return requests;
	}

	/**
	 * This method will take in a Date and return a List of Requests of the same
	 * date. It takes a Date 'theDate'as parameter.
	 * 
	 * @param theDate
	 * @return
	 */
	public List<Request> getRequestByTime(Date theDate) {
		List<Request> foundRequests = new ArrayList<Request>();
		for (Request r : requests) {
			if (r.getRequestTime() == theDate) {
				foundRequests.add(r);
			}
		}
		return foundRequests;
	}

	/**
	 * This method will add a request to the requests array, it takes the
	 * parameter 'r'.
	 * 
	 * @param r
	 */
	public void addRequest(Request r) {
		int newID = 0;
		for (Request req : requests) {
			if (req.getRequestID() > newID) {
				newID = req.getRequestID();
			}
		}
		newID++;
		r.setRequestID(newID);
		requests.add(r);
	}

	/**
	 * This will find a request by its id, it needs aloop and will through.
	 * 'RequestNotFoundException()'
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	
	public Request findRequestByID(int id) throws Exception {
		Iterator<Request> r = requests.iterator();
		while (r.hasNext()) {
			Request theRequest = r.next();
			if (theRequest.getRequestID() == id) {
				return theRequest;
			}

		}
		throw new RequestNotFoundException();
	}
	
	
	
	public List<Request> findRequestsByIds(List<Integer> idArr) throws Exception {
		List<Request> foundRequests = new ArrayList<Request>();
		Iterator<Request> r = requests.iterator();
		while (r.hasNext()) {
			Iterator<Integer> i = idArr.iterator();
			Request theRequest = r.next();
			while (i.hasNext()) {
				Integer theID = i.next();
				if (theID.equals(theRequest.getRequestID())) {
					foundRequests.add(theRequest);
				}
			}

		}
		
		return foundRequests;
	}
	
	/**
	 * This method will remove a SINGLE request by passing in its id 'id'.
	 * 
	 * @param id
	 */

	public void removeRequest(int id) throws Exception {
		Iterator<Request> r = requests.iterator();
		while (r.hasNext()) {
			Request theRequest = r.next();
			if (theRequest.getRequestID() == id) {
				r.remove();
				return;
			}

		}
		throw new RequestNotFoundException();
	}

	/**
	 * Similar to the 'removeRequest' method, this method will take in an array
	 * of IDs and check the array for said IDs, it will then delete them from
	 * the array List
	 * 
	 * @param idArr
	 */
	public void removeRequestsByIds(List<Integer> idArr) throws Exception {
		Iterator<Request> r = requests.iterator();
		while (r.hasNext()) {
			Iterator<Integer> i = idArr.iterator();
			Request theRequest = r.next();
			while (i.hasNext()) {
				Integer theID = i.next();
				if (theID.equals(theRequest.getRequestID())) {
					r.remove();
				}
			}

		}
	}
}
