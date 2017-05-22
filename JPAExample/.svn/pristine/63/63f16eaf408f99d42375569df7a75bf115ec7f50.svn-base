package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fdmgroup.util.IDGenerator;

@Entity
@Table(name= "JPA_STOCK")
public class Stock {

	@Column
	@Id
	private long id;
	
	@Column
	private String name;
	
	@OneToOne(mappedBy = "stock")
	private Company company;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String name) {
		super();
		this.id = IDGenerator.generate();
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
