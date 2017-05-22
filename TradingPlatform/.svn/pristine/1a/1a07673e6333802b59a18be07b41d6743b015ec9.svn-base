package com.fdmgroup.tradingplatform.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class User implements IStorable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private String passWord;
	private List<Role> roles;
	private HashMap<Integer, Integer> portfolio;
	/*
	 * public List<Request> requests; public List<Trade> buyTrades; public
	 * List<Trade> sellTrades; public List<Share> shares;
	 */

	public HashMap<Integer, Integer> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(HashMap<Integer, Integer> portfolio) {
		this.portfolio = portfolio;
	}





	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", passWord=" + passWord + ", roles=" + roles + ", portfolio=" + portfolio + "]";
	}

	public User() {

	}

	public User(String userName, String firstName, String lastName, String passWord, List<Role> roles) {

		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passWord = passWord;
		this.roles = roles;
	}
	

	public User(Integer id, String userName, String firstName, String lastName, String passWord, List<Role> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passWord = passWord;
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}


	/*
	 * public List<Request> getRequests() { return requests; }
	 * 
	 * public void setRequests(List<Request> requests) { this.requests =
	 * requests; }
	 * 
	 * public List<Trade> getBuyTrades() { return buyTrades; }
	 * 
	 * public void setBuyTrades(List<Trade> buyTrades) { this.buyTrades =
	 * buyTrades; }
	 * 
	 * public List<Trade> getSellTrades() { return sellTrades; }
	 * 
	 * public void setSellTrades(List<Trade> sellTrades) { this.sellTrades =
	 * sellTrades; }
	 * 
	 * public List<Share> getShares() { return shares; }
	 * 
	 * public void setShares(List<Share> shares) { this.shares = shares; }
	 */

}
