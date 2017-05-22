package entities;

import java.io.Serializable;

import javax.persistence.*;

import dto.IStorable;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TRADE database table.
 * 
 */
@Entity
@NamedQuery(name="Trade.findAll", query="SELECT t FROM Trade t")
public class Trade implements Serializable, IStorable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TRADE_ID")
	private Integer tradeId;

	@Column(name="PRICE_TOTAL")
	private BigDecimal priceTotal;

	@Column(name="SHARE_PRICE")
	private BigDecimal sharePrice;

	private BigDecimal shares;

	@Column(name="STOCK_ID")
	private BigDecimal stockId;

	@Temporal(TemporalType.DATE)
	@Column(name="TRANSACTION_TIME")
	private Date transactionTime;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="SELLER_ID")
	private Person person1;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="BUYER_ID")
	private Person person2;

	//bi-directional many-to-one association to Request
	@ManyToOne
	@JoinColumn(name="BUY_REQUEST_ID")
	private Request request1;

	//bi-directional many-to-one association to Request
	@ManyToOne
	@JoinColumn(name="SELL_REQUEST_ID")
	private Request request2;

	public Trade() {
	}

	public Integer getTradeId() {
		return this.tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	public BigDecimal getPriceTotal() {
		return this.priceTotal;
	}

	public void setPriceTotal(BigDecimal priceTotal) {
		this.priceTotal = priceTotal;
	}

	public BigDecimal getSharePrice() {
		return this.sharePrice;
	}

	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}

	public BigDecimal getShares() {
		return this.shares;
	}

	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}

	public BigDecimal getStockId() {
		return this.stockId;
	}

	public void setStockId(BigDecimal stockId) {
		this.stockId = stockId;
	}

	public Date getTransactionTime() {
		return this.transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Person getPerson1() {
		return this.person1;
	}

	public void setPerson1(Person person1) {
		this.person1 = person1;
	}

	public Person getPerson2() {
		return this.person2;
	}

	public void setPerson2(Person person2) {
		this.person2 = person2;
	}

	public Request getRequest1() {
		return this.request1;
	}

	public void setRequest1(Request request1) {
		this.request1 = request1;
	}

	public Request getRequest2() {
		return this.request2;
	}

	public void setRequest2(Request request2) {
		this.request2 = request2;
	}

}