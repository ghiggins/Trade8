package com.tradingPlatform.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tradingPlatform.exceptions.CompanyNotFoundException;
import com.tradingPlatform.exceptions.RequestNotFoundException;
import com.tradingPlatform.model.entities.Company;
import com.tradingPlatform.model.entities.Request;



/**
 * This is the CompanyController class, which will
 * manipulate the companies list.
 * @author alexander.evans2
 *
 */
public class CompanyController {
	
	List<Company> companies = new ArrayList<Company>();
	
	/**
	 * This method will take a passed company and add it to the
	 * companies list
	 * @param c
	 */
	public void addCompany(Company c) {
		int newID = 0;
		for (Company com : companies) {
			if (com.getCompanyID() > newID) {
				newID = com.getCompanyID();
			}
		}
		newID++;
		c.setCompanyID(newID);
		companies.add(c);
	}
	
	
	/**
	 * This method will take in an id and remove the company with the corresponding 
	 * id
	 * @param id
	 */
	public void removeCompany(int id) throws Exception {
		Iterator<Company> c = companies.iterator();
		while (c.hasNext()) {
			Company theCompany = c.next();
			if (theCompany.getCompanyID() == id) {
				c.remove();
				return;
			}

		}
		throw new CompanyNotFoundException();
	}
	
	
	/**
	 * This method will take in an array of company IDs and then 
	 * loop through said array to remove all companies of 
	 * said id from the companies array
	 * @param idArr
	 */
	public void removeCompaniesByIds(List<Integer> idArr) throws Exception {
		Iterator<Company> c = companies.iterator();
		while (c.hasNext()) {
			Iterator<Integer> i = idArr.iterator();
			Company theCompany = c.next();
			while (i.hasNext()) {
				Integer theID = i.next();
				if (theID.equals(theCompany.getCompanyID())) {
					c.remove();
				}
			}

		}
	}
	
	
	/**
	 * This method will find and return one company whos ID corresponds
	 * to the id passed into the method.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Company findCompanyByID(int id) throws Exception {
		Iterator<Company> c = companies.iterator();
		while (c.hasNext()) {
			Company theCompany = c.next();
			if (theCompany.getCompanyID() == id) {
				return theCompany;
			}

		}
		throw new CompanyNotFoundException();
	}
	
	
	public List<Company> findCompaniesByIDs(List<Integer> idArr) throws Exception {
		List<Company> foundCompanies = new ArrayList<Company>();
		Iterator<Company> c = companies.iterator();
		while (c.hasNext()) {
			Iterator<Integer> i = idArr.iterator();
			Company theCompany = c.next();
			while (i.hasNext()) {
				Integer theID = i.next();
				if (theID.equals(theCompany.getCompanyID())) {
					foundCompanies.add(theCompany);
				}
			}

		}
		
		return foundCompanies;
	}
	
	/**
	 * similar to the findCompanyByID method, this method will find and
	 * return one company whos name corresponds with the 'name' parameter
	 * passed into the function.
	 * @param name
	 * @return
	 * @throws Exception
	 */
	
	public Company findCompanyByName(String name) throws Exception {
		Iterator<Company> c = companies.iterator();
		while (c.hasNext()) {
			Company theCompany = c.next();
			if (theCompany.getCompanyName() == name) {
				return theCompany;
			}

		}
		throw new CompanyNotFoundException();
	}
	
	/**
	 * this method will check to see if the company (with the ID)
	 * is listed or isnt, and will change the boolean as such.
	 * @param id
	 */
	public void toggleListing(int id){
		for (Company c : companies){
			if(c.getCompanyID() == id){
				if(c.getListed() == true){
					c.setListed(false);
				}
				else{
					c.setListed(true);
				}
			}
		}
	}

	/**
	 * this function will return the companies arraylist
	 * @return
	 */
	public List<Company> getAllCompanies(){
		return companies;
	}
	
	
}
