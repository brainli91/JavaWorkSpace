package dto;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRADE")
public class TradeDTO implements IStorable{

	@Id
	@Column(name="TRADE_ID")
	int trade_id;
	@Column(name="STOCK_ID")
	int stock_id;
	@Column(name="TRANSACTION_TIME")
	Date transaction_time;
	@Column(name="SHARES")
	BigDecimal shares;
	@Column(name="SHARE_PRICE")
	BigDecimal share_price;
	@Column(name="PRICE_TOTAL")
	BigDecimal price_total;
	@Column(name="BUYER_ID")
	int buyer_id;
	@Column(name="SELLER_ID")
	int seller_id;
	@Column(name="BUY_REQUEST_ID")
	int buy_request_id;
	@Column(name="SELL_REQUEST_ID")
	int sell_request_id;
	
	public int getTrade_id() {
		return trade_id;
	}
	public void setTrade_id(int trade_id) {
		this.trade_id = trade_id;
	}
	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public Date getTransaction_time() {
		return transaction_time;
	}
	public void setTransaction_time(Date transaction_time) {
		this.transaction_time = transaction_time;
	}
	public BigDecimal getShares() {
		return shares;
	}
	public void setShares(BigDecimal shares) {
		this.shares = shares;
	}
	public BigDecimal getShare_price() {
		return share_price;
	}
	public void setShare_price(BigDecimal share_price) {
		this.share_price = share_price;
	}
	public BigDecimal getPrice_total() {
		return price_total;
	}
	public void setPrice_total(BigDecimal price_total) {
		this.price_total = price_total;
	}
	public int getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getBuy_request_id() {
		return buy_request_id;
	}
	public void setBuy_request_id(int buy_request_id) {
		this.buy_request_id = buy_request_id;
	}
	public int getSell_request_id() {
		return sell_request_id;
	}
	public void setSell_request_id(int sell_request_id) {
		this.sell_request_id = sell_request_id;
	}
	
	
}
