package com.fdmgroup.tradingplatform.bin;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TRADE")
public class Trade {

	@SequenceGenerator(name="TRADE_ID_SEQ", initialValue=1, allocationSize=50)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRADE_ID_SEQ")
	@Id
	@Column(name = "TRADE_ID")
	private int tradeId;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "STOCK_ID", referencedColumnName="STOCK_ID")	
	private Company company;
	
	@Column(name = "TRANSACTION_TIME")
	private String transactionTime;
	
	@Column(name = "SHARES")
	private int shares;
	
	@Column(name = "SHARE_PRICE")
	private BigDecimal sharePrice;
	
	@Column(name = "PRICE_TOTAL")
	private BigDecimal priceTotal;
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "SELLER_ID")
	private Person person1;	
	
	@ManyToOne(cascade = {CascadeType.MERGE})
	@JoinColumn(name = "BUYER_ID")
	private Person person2;
	
	@ManyToOne(cascade = {CascadeType.MERGE})	
	@JoinColumn(name = "BUY_REQUEST_ID")
	private Request request1;
	
	@ManyToOne(cascade = {CascadeType.MERGE})	
	@JoinColumn(name = "SELL_REQUEST_ID")
	private Request request2;
	
	public Trade(int tradeId, Company company, String transactionTime, int shares, BigDecimal sharePrice,
			BigDecimal priceTotal, Person buyer, Person seller, Request buyRequest, Request sellRequest) {
		super();
		this.tradeId = tradeId;
		this.company = company;
		this.transactionTime = transactionTime;
		this.shares = shares;
		this.sharePrice = sharePrice;
		this.priceTotal = priceTotal;
		this.person1 = buyer;
		this.person2 = seller;
		this.request1 = buyRequest;
		this.request2 = sellRequest;
	}

	public Trade(){
		
	}
	
	public int getTradeId() {
		return tradeId;
	}
	
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getTransactionTime() {
		return transactionTime;
	}
	
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	
	public int getShares() {
		return shares;
	}
	
	public void setShares(int shares) {
		this.shares = shares;
	}
	
	public BigDecimal getSharePrice() {
		return sharePrice;
	}
	
	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}
	
	public BigDecimal getPriceTotal() {
		return priceTotal;
	}
	
	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}

	public Person getPerson1() {
		return person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public Request getRequest1() {
		return request1;
	}

	public void setRequest1(Request request1) {
		this.request1 = request1;
	}

	public Request getRequest2() {
		return request2;
	}

	public void setRequest2(Request request2) {
		this.request2 = request2;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", company=" + company.getCompanyId()
				+ ", transactionTime=" + transactionTime + ", shares=" + shares
				+ ", sharePrice=" + sharePrice + ", priceTotal=" + priceTotal
				+ ", sellerId=" + person1.getPersonId() + ", buyerId=" + person2.getPersonId()
				+ ", sell requestId=" + request2.getRequestId() + ", buy requestId=" + request1.getRequestId() + "]";
	}
	
}
