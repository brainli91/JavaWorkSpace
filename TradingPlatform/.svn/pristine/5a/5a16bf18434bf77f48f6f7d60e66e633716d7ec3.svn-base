package com.fdmgroup.tradingplatform.model;

import java.io.Serializable;
import java.sql.Date;

public class Request implements IStorable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Request parent;
	private Integer sharesFilled;
	private User shareholder;
	private Date requestDate;
	private String type;
	private String status;
	private Company company;
	private Integer shareCount;
	private Integer minShares;
	private String timeInForce;
	private Double limitPrice;
	private Double stopPrice;
	/*
	 * private Trade buyTrade; private Trade sellTrade;
	 */

	@Override
	public String toString() {
		return "Request [id=" + id + ", parent=" + parent + ", sharesFilled=" + sharesFilled + ", shareholder="
				+ shareholder + ", requestDate=" + requestDate + ", type=" + type + ", status=" + status + ", company="
				+ company + ", shares=" + shareCount + ", minShares=" + minShares + ", timeInForce=" + timeInForce
				+ ", limitPrice=" + limitPrice + ", stopPrice=" + stopPrice + "]";
	}

	public Request() {
		super();
	}

	public Request(Request parent, Integer sharesFilled, User shareholder, Date requestDate, String type, String status,
			Company company, Integer shareCount, Integer minShares, String timeInForce, Double limitPrice,
			Double stopPrice) {
		super();
		this.parent = parent;
		this.sharesFilled = sharesFilled;
		this.shareholder = shareholder;
		this.requestDate = requestDate;
		this.type = type;
		this.status = status;
		this.company = company;
		this.shareCount = shareCount;
		this.minShares = minShares;
		this.timeInForce = timeInForce;
		this.limitPrice = limitPrice;
		this.stopPrice = stopPrice;
	}

	public Request(Integer id, Request parent, Integer sharesFilled, User shareholder, Date requestDate, String type,
			String status, Company company, Integer shareCount, Integer minShares, String timeInForce,
			Double limitPrice, Double stopPrice) {
		super();
		this.id = id;
		this.parent = parent;
		this.sharesFilled = sharesFilled;
		this.shareholder = shareholder;
		this.requestDate = requestDate;
		this.type = type;
		this.status = status;
		this.company = company;
		this.shareCount = shareCount;
		this.minShares = minShares;
		this.timeInForce = timeInForce;
		this.limitPrice = limitPrice;
		this.stopPrice = stopPrice;
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
		Request other = (Request) obj;
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

	public Request getParent() {
		return parent;
	}

	public void setParent(Request parent) {
		this.parent = parent;
	}

	public Integer getSharesFilled() {
		return sharesFilled;
	}

	public void setSharesFilled(Integer sharesFilled) {
		this.sharesFilled = sharesFilled;
	}

	public User getShareholder() {
		return shareholder;
	}

	public void setShareholder(User shareholder) {
		this.shareholder = shareholder;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getMinShares() {
		return minShares;
	}

	public void setMinShares(Integer minShares) {
		this.minShares = minShares;
	}

	public String getTimeInForce() {
		return timeInForce;
	}

	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}

	public Double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public Double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(Double stopPrice) {
		this.stopPrice = stopPrice;
	}

	/*
	 * public Trade getBuyTrade() { return buyTrade; }
	 * 
	 * public void setBuyTrade(Trade buyTrade) { this.buyTrade = buyTrade; }
	 * 
	 * public Trade getSellTrade() { return sellTrade; }
	 * 
	 * public void setSellTrade(Trade sellTrade) { this.sellTrade = sellTrade; }
	 */

}
