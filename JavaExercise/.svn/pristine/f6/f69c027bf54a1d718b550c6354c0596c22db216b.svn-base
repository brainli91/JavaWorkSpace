package com.fdmgroup.bankdesign;

import java.util.ArrayList;
import java.util.List;
public abstract class Customer {
	
	private int customerId;
	private String name;
	private String address;
	private String taxId;

	/*
	 * Maintain a list of all the related accounts to customer
	 */
	// consider changing ref to List<Integer>
	private List<Integer> accountIds = new ArrayList<Integer>();
	
	protected Customer(int customerId, String name, String address, String taxId){
		this.setCustomerId(customerId);
		this.setName(name);
		this.setAddress(address);
		this.setTaxId(taxId);
		this.setAccountIds();
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getTaxId() {
		return taxId;
	}
	
	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
	
	public List<Integer> getAccountIds() {
		return accountIds;
	}
	
	public void setAccountIds() {
		this.accountIds = new ArrayList<Integer>();
	}
	
	public void addAccountId(int accountId) {
		this.accountIds.add(accountId);
	}	
	

}