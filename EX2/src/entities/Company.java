package entities;

import java.io.Serializable;

import javax.persistence.*;

import dto.IStorable;

import java.math.BigDecimal;


/**
 * The persistent class for the COMPANY database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable, IStorable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COMPANY_ID")
	private Integer companyId;

	private String name;

	@Column(name="STARTING_PRICE")
	private BigDecimal startingPrice;

	@Column(name="STOCK_ID")
	private BigDecimal stockId;

	public Company() {
	}

	public Integer getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getStartingPrice() {
		return this.startingPrice;
	}

	public void setStartingPrice(BigDecimal startingPrice) {
		this.startingPrice = startingPrice;
	}

	public BigDecimal getStockId() {
		return this.stockId;
	}

	public void setStockId(BigDecimal stockId) {
		this.stockId = stockId;
	}

}