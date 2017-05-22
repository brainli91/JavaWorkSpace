package com.fdmgroup.tradingplatform.model;

import java.io.Serializable;
import java.util.List;

public class Company implements IStorable, Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer stockId;
	private String name;
	private Double startingPrice;
	// private List<Request> requests;
	// private List<Trade> trades;
	// private List<Share> shares;	 
	private List<AuthorizedShare> authorizedShares;

	public Company(){
		super();
	}
	
	public Company( String name, Double startingPrice) {
		this.name = name;
		this.startingPrice = startingPrice;
	}

	public Company(Integer id, Integer stockId, String name, Double startingPrice) {
		this.id = id;
		this.stockId = stockId;
		this.name = name;
		this.startingPrice = startingPrice;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", startingPrice=" + startingPrice + "]";
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
		Company other = (Company) obj;
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

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(Double startingPrice) {
		this.startingPrice = startingPrice;
	}
	/*
	 * public List<Request> getRequests() { return requests; } public void
	 * setRequests(List<Request> requests) { this.requests = requests; } public
	 * List<Trade> getTrades() { return trades; } public void
	 * setTrades(List<Trade> trades) { this.trades = trades; } public
	 * List<Share> getShares() { return shares; } public void
	 * setShares(List<Share> shares) { this.shares = shares; } public
	 * List<AuthorizedShare> getAuthorizedShares() { return authorizedShares; }
	 * public void setAuthorizedShares(List<AuthorizedShare> authorizedShares) {
	 * this.authorizedShares = authorizedShares; }
	 */

	public List<AuthorizedShare> getAuthorizedShares() {
		return authorizedShares;
	}

	public void setAuthorizedShares(List<AuthorizedShare> authorizedShares) {
		this.authorizedShares = authorizedShares;
	}

}
