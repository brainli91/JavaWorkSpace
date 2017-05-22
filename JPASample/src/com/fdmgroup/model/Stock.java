package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "JPA_STOCK")
public class Stock {

	@Id
	@Column(name = "stockId")
	@SequenceGenerator(name = "jpa_stock_sequence", sequenceName = "JPA_STOCK_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_stock_sequence")
/*	@GeneratedValue(strategy = GenerationType.AUTO)*/
	private int id;
	@Column
	private String stockName;
	
	@OneToOne(mappedBy="stock")
	private Company company;

	public Stock(int id, String stockName) {
		super();
		this.id = id;
		this.stockName = stockName;
	}

	public Stock(String stockName) {
		super();
		this.stockName = stockName;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockName=" + stockName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Stock other = (Stock) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
