package entities;

import java.io.Serializable;

import javax.persistence.*;

import dto.IStorable;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the REQUEST database table.
 * 
 */
@Entity
@NamedQuery(name="Request.findAll", query="SELECT r FROM Request r")
public class Request implements Serializable, IStorable {
	private static final long serialVersionUID = 1L;

	public enum BuyOrSell {
		BUY, SELL;
	}

	public enum Status {
		ACTIVE, PARTIAL_FILL, COMPLETED, CANCELLED;
	}

	public enum timeInForce {
		DAY_ONLY, GOOD_UNTIL_CANCELLED, IMMEDIATE_OR_CANCEL;
	}
	
	@Id
//	@GeneratedValue(generator="REQUEST_ID_SEQ")
//	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
	@Column(name="REQUEST_ID")
	private Integer requestId;

	@Column(name="BUY_SELL")
	private String buySell;

	@Column(name="LIMIT_PRICE")
	private BigDecimal limitPrice;

	@Column(name="MINIMUM_SHARES")
	private BigDecimal minimumShares;

	@Temporal(TemporalType.DATE)
	@Column(name="REQUEST_DATE")
	private Date requestDate;

	private BigDecimal shares;

	@Column(name="SHARES_FILLED")
	private BigDecimal sharesFilled;

	private String status;

	@Column(name="STOCK_ID")
	private BigDecimal stockId;

	@Column(name="STOP_PRICE")
	private BigDecimal stopPrice;

	@Column(name="TIME_IN_FORCE")
	private String timeInForce;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="SHAREHOLDER_ID")
	private Person person;

	//bi-directional many-to-one association to Request
	@ManyToOne
	@JoinColumn(name="PARENT_REQUEST_ID")
	private Request request;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="request")
	private List<Request> requests;

	//bi-directional many-to-one association to Trade
	@OneToMany(mappedBy="request1")
	private List<Trade> trades1;

	//bi-directional many-to-one association to Trade
	@OneToMany(mappedBy="request2")
	private List<Trade> trades2;

	public Request() {
	}

	public Integer getRequestId() {
		return this.requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public String getBuySell() {
		return this.buySell;
	}

	public void setBuySell(BuyOrSell buySell) {
		this.buySell = buySell.toString();
	}
	
	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}

	public BigDecimal getLimitPrice() {
		return this.limitPrice;
	}

	public void setLimitPrice(BigDecimal limitPrice) {
		this.limitPrice = limitPrice;
	}

	public BigDecimal getMinimumShares() {
		return this.minimumShares;
	}

	public void setMinimumShares(BigDecimal minimumShares) {
		this.minimumShares = minimumShares;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public BigDecimal getShares() {
		return this.shares;
	}

	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}

	public BigDecimal getSharesFilled() {
		return this.sharesFilled;
	}

	public void setSharesFilled(BigDecimal sharesFilled) {
		this.sharesFilled = sharesFilled;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getStockId() {
		return this.stockId;
	}

	public void setStockId(BigDecimal stockId) {
		this.stockId = stockId;
	}

	public BigDecimal getStopPrice() {
		return this.stopPrice;
	}

	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}

	public String getTimeInForce() {
		return this.timeInForce;
	}

	public void setTimeInForce(timeInForce timeInForce) {
		this.timeInForce = timeInForce.toString().replace("_", " ");
	}
	
	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Request getRequest() {
		return this.request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setRequest(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setRequest(null);

		return request;
	}

	public List<Trade> getTrades1() {
		return this.trades1;
	}

	public void setTrades1(List<Trade> trades1) {
		this.trades1 = trades1;
	}

	public Trade addTrades1(Trade trades1) {
		getTrades1().add(trades1);
		trades1.setRequest1(this);

		return trades1;
	}

	public Trade removeTrades1(Trade trades1) {
		getTrades1().remove(trades1);
		trades1.setRequest1(null);

		return trades1;
	}

	public List<Trade> getTrades2() {
		return this.trades2;
	}

	public void setTrades2(List<Trade> trades2) {
		this.trades2 = trades2;
	}

	public Trade addTrades2(Trade trades2) {
		getTrades2().add(trades2);
		trades2.setRequest2(this);

		return trades2;
	}

	public Trade removeTrades2(Trade trades2) {
		getTrades2().remove(trades2);
		trades2.setRequest2(null);

		return trades2;
	}

}