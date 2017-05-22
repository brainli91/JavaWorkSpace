package com.fdmgroup.tradingplatform.bin;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "COMPANY_ID")
	private int companyId;
	
	@Column(name = "NAME")	
	private String name;
	
	@Column(name = "STOCK_ID")
	private int stockId;
	
	@Column(name = "STARTING_PRICE")
	private BigDecimal startingPrice;
	
	public Company(int companyId, String name, int stockId, BigDecimal startingPrice) {
		super();
		this.companyId = companyId;
		this.name = name;
		this.stockId = stockId;
		this.startingPrice = startingPrice;
	}

	public Company(){
		
	}
	
	public int getCompanyId() {
		return companyId;
	}
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStockId() {
		return stockId;
	}
	
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	public BigDecimal getStartingPrice() {
		return startingPrice;
	}
	
	public void setStartingPrice(BigDecimal startingPrice) {
		this.startingPrice = startingPrice;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", name=" + name + ", stockId=" + stockId + ", startingPrice="
				+ startingPrice + "]";
	}
	
	
}
