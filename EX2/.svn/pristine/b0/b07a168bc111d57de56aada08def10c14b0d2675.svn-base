package dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "REQUEST")
public class RequestDTO implements IStorable {

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
	@Column(name = "REQUEST_ID")
	int request_id;
	@Transient
	@Column(name = "PARENT_REQUEST_ID")
	int parent_request_id;
	@Transient
	@Column(name = "SHARES_FILLED")
	int shares_filled;
	@Column(name = "SHAREHOLDER_ID")
	int shareholder_id;
	@Temporal(TemporalType.DATE)
	@Column(name = "REQUEST_DATE")
	Date request_date;

	@Column(name = "BUY_SELL")
	@Enumerated(EnumType.STRING)
	BuyOrSell buy_or_sell;

	@Column(name = "STATUS")
	String status;

	@Column(name = "STOCK_ID")
	int stock_id;
	@Column(name = "SHARES")
	int shares;
	@Column(name = "MINIMUM_SHARES")
	int minimum_shares;
	@Column(name = "TIME_IN_FORCE")
	String time_in_force;
	@Column(name = "LIMIT_PRICE")
	BigDecimal limit_price;
	@Column(name = "STOP_PRICE")
	BigDecimal stop_price;

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	public int getParent_request_id() {
		return parent_request_id;
	}

	public void setParent_request_id(int parent_request_id) {
		this.parent_request_id = parent_request_id;
	}

	public int getShares_filled() {
		return shares_filled;
	}

	public void setShares_filled(int shares_filled) {
		this.shares_filled = shares_filled;
	}

	public int getShareholder_id() {
		return shareholder_id;
	}

	public void setShareholder_id(int shareholder_id) {
		this.shareholder_id = shareholder_id;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public BuyOrSell getBuy_or_sell() {
		return buy_or_sell;
	}

	public void setBuy_or_sell(BuyOrSell buy_or_sell) {
		this.buy_or_sell = buy_or_sell;
	}

	public int getStock_id() {
		return stock_id;
	}

	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}

	public int getShares() {
		return shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public int getMinimum_shares() {
		return minimum_shares;
	}

	public void setMinimum_shares(int minimum_shares) {
		this.minimum_shares = minimum_shares;
	}

	public BigDecimal getLimit_price() {
		return limit_price;
	}

	public void setLimit_price(BigDecimal limit_price) {
		this.limit_price = limit_price;
	}

	public BigDecimal getStop_price() {
		return stop_price;
	}

	public void setStop_price(BigDecimal stop_price) {
		this.stop_price = stop_price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status.toString().replace("_" , " " );
	}
	
	public void setStatus(String status){
		this.status=status;
	}

	public String getTime_in_force() {
		return time_in_force.replace("_", " ");
	}

	public void setTime_in_force(timeInForce time_in_force) {
		this.time_in_force = time_in_force.toString().replace("_", " ");
	}
	
	public void setTime_in_force(String time_in_force) {
		this.time_in_force = time_in_force.replace("_", " ");
	}
}
