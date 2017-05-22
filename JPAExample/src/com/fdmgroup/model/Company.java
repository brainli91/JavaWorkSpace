package com.fdmgroup.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fdmgroup.util.IDGenerator;

@Entity
@Table(name ="JPA_COMPANY")
@SecondaryTables({
	@SecondaryTable(name ="JPA_COMPANY_PROFILE", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "id"))
	
})
@NamedQueries({
	@NamedQuery(name ="company.findAll",query = "SELECT c FROM Company c"),
	@NamedQuery(name ="company.findByEstalished",query = "SELECT c FROM Company c WHERE c.established BETWEEN :fromDate AND :toDate")
})
public class Company {
	@Id
	@Column
	private long id;
	
	@Column
	private String name;
	
	@Column(table="JPA_COMPANY_PROFILE")
	private String address;
	
	@Column(table="JPA_COMPANY_PROFILE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date established;
	
	@Column(table="JPA_COMPANY_PROFILE")
	private int numberOfEmployee;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Stock stock;
	
	@OneToMany(mappedBy ="company")
	//JoinTable()
	private Set<User> users;
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

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

	public int getNumberOfEmployee() {
		return numberOfEmployee;
	}

	public void setNumberOfEmployee(int numberOfEmployee) {
		this.numberOfEmployee = numberOfEmployee;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address
				+ ", established=" + established + ", numberOfEmployee="
				+ numberOfEmployee + "]";
	}

	public Company(String name, String address, Date established,
			int numberOfEmployee, Stock stock) {
		super();
		this.id =IDGenerator.generate();
		this.name = name;
		this.address = address;
		this.established = established;
		this.numberOfEmployee = numberOfEmployee;
		this.stock = stock;
	}
	
	
	
}
