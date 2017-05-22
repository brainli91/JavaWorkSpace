package com.fdmgroup.tradingplatform.bin;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REQUEST")
public class Request {
	
	@SequenceGenerator(name="REQUEST_ID_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REQUEST_ID_SEQ")
	@Id
	@Column(name = "REQUEST_ID")
	private int requestId;
	
	@ManyToOne(cascade = {CascadeType.MERGE})	
	@JoinColumn(name = "PARENT_REQUEST_ID")
	private Request request;
	
	@Column(name = "SHARES_FILLED")
	private int sharesFilled;
	
	@ManyToOne(cascade = {CascadeType.MERGE})		
	@JoinColumn(name = "SHAREHOLDER_ID")
	private Person person;
	
	@Column(name = "REQUEST_DATE")
	private Date requestDate;
	
	@Column(name = "BUY_SELL")
	private String buySell;
	
	@Column(name = "STATUS")
	private String status;
	
	@ManyToOne(cascade = {CascadeType.MERGE})	
	@JoinColumn(name = "STOCK_ID", referencedColumnName="STOCK_ID")	
	private Company company;
	
	@Column(name = "SHARES")
	private int shares;
	
	@Column(name = "MINIMUM_SHARES")
	private int minimumShares;
	
	@Column(name = "TIME_IN_FORCE")
	private String timeInForce;
	
	@Column(name = "LIMIT_PRICE")
	private BigDecimal limitPrice;
	
	@Column(name = "STOP_PRICE")
	private BigDecimal stopPrice;

	public Request(Request request, int sharesFilled,
			Person person, Date requestDate, String buySell, String status,
			Company company, int shares, int minimumShares, String timeInForce,
			BigDecimal limitPrice, BigDecimal stopPrice) {
		super();
		this.request = request;
		this.sharesFilled = sharesFilled;
		this.person = person;
		this.requestDate = requestDate;
		this.buySell = buySell;
		this.status = status;
		this.company = company;
		this.shares = shares;
		this.minimumShares = minimumShares;
		this.timeInForce = timeInForce;
		this.limitPrice = limitPrice;
		this.stopPrice = stopPrice;
	}

	public Request(){
		
	}
	
	public int getRequestId() {
		return requestId;
	}

	public int getSharesFilled() {
		return sharesFilled;
	}

	public void setSharesFilled(int sharesFilled) {
		this.sharesFilled = sharesFilled;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getBuySell() {
		return buySell;
	}

	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getMinimumShares() {
		return minimumShares;
	}

	public void setMinimumShares(int minimumShares) {
		this.minimumShares = minimumShares;
	}

	public String getTimeInForce() {
		return timeInForce;
	}

	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}

	public BigDecimal getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(BigDecimal limitPrice) {
		this.limitPrice = limitPrice;
	}

	public BigDecimal getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}
	
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", request=" + request
				+ ", sharesFilled=" + sharesFilled + ", personId=" + person.getPersonId()
				+ ", requestDate=" + requestDate + ", buySell=" + buySell
				+ ", status=" + status + ", companyId=" + company.getCompanyId() + ", shares="
				+ shares + ", minimumShares=" + minimumShares
				+ ", timeInForce=" + timeInForce + ", limitPrice=" + limitPrice
				+ ", stopPrice=" + stopPrice + "]";
	}

}
