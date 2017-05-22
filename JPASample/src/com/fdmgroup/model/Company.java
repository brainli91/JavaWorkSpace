package com.fdmgroup.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "JPA_COMPANY")
@SecondaryTables({
@SecondaryTable(name="JPA_COMPANY_PROFILE", pkJoinColumns = @PrimaryKeyJoinColumn)
})
@NamedQueries({
@NamedQuery(name="company.findByDate", query="SELECT c FROM Company c WHERE c.established BETWEEN :fromDate AND :toDate")
})
public class Company {

	@Id
	@Column(name = "companyId")
	@SequenceGenerator(name = "jpa_company_sequence", sequenceName = "JPA_COMPANY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_company_sequence")
	private int id;

	@Column
	private String name;
	@Column
	private double startPrice;

	@OneToMany(mappedBy = "company")
	private List<User> users;
	
	@OneToOne(cascade=CascadeType.ALL, fetch= FetchType.LAZY)
	private Stock stock;
	
	@Column(table="JPA_COMPANY_PROFILE")
	private String address;
	
	@Column(table="JPA_COMPANY_PROFILE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date established;
	
	@Column(table="JPA_COMPANY_PROFILE")
	private int numberOfEmployees;
	
	
	
	public Company() {
		super();
	}


	public Company(int id, String name, double startPrice, Stock stock, String address, Date established,
			int numberOfEmployees) {
		super();
		this.id = id;
		this.name = name;
		this.startPrice = startPrice;
		this.stock = stock;
		this.address = address;
		this.established = established;
		this.numberOfEmployees = numberOfEmployees;
	}


	
	


	public Company(String name, double startPrice, Stock stock, String address, Date established,
			int numberOfEmployees) {
		super();
		this.name = name;
		this.startPrice = startPrice;
		this.stock = stock;
		this.address = address;
		this.established = established;
		this.numberOfEmployees = numberOfEmployees;
	}


	public Company(String name, double startPrice, List<User> users, Stock stock, String address, Date established,
			int numberOfEmployees) {
		super();
		this.name = name;
		this.startPrice = startPrice;
		this.users = users;
		this.stock = stock;
		this.address = address;
		this.established = established;
		this.numberOfEmployees = numberOfEmployees;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(double startPrice) {
		this.startPrice = startPrice;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getEstablished() {
		return established;
	}

	public void setEstablished(Date established) {
		this.established = established;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
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
		Company other = (Company) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", startPrice=" + startPrice + ", stock=" + stock + ", address="
				+ address + ", established=" + established + ", numberOfEmployees=" + numberOfEmployees + "]";
	}


}
