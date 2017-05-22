package com.fdmgroup.tradingplatform.bin;

import java.util.HashSet;
import java.util.Set;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="PERSON")
public class Person {
	
	@Id
	@Column(name = "PERSON_ID")
	private int personId;
	
	@Column(name = "PASSWORD")	
	private String password;
	
	@Column(name = "USER_NAME")	
	private String userName;

	@Column(name = "FIRST_NAME")	
	private String firstName;
	
	@Column(name = "LAST_NAME")	
	private String lastName;
	
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", 
               joinColumns = @JoinColumn(name = "UR_PERSON_ID", referencedColumnName="PERSON_ID"), 
               inverseJoinColumns = @JoinColumn(name = "UR_ROLE_ID", referencedColumnName="ROLE_ID"))
    private Set<Role> roles = new HashSet<Role>();

	public Person(int personId, String password, String userName, String firstName, String lastName,
			Set<Role> roles) {
		super();
		this.personId = personId;
		this.password = password;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
	}

	public Person(){
		
	}
	
	public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int person_id) {
		this.personId = person_id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFirstname() {
		return firstName;
	}
	
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}	
	
}
