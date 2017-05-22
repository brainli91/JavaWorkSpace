package entities;

import java.io.Serializable;

import javax.persistence.*;

import dto.IStorable;

import java.util.List;


/**
 * The persistent class for the PERSON database table.
 * 
 */
@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable, IStorable {
	private static final long serialVersionUID = 1L;
	
	public Person(int personId, String userName, String password, String firstName, String lastName){
		this.personId=personId;
		this.userName=userName;
		this.password=password;
		this.firstName=firstName;
		this.lastName=lastName;
	}

	@Id
	@Column(name="PERSON_ID")
	private Integer personId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String password;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional many-to-one association to Request
	@OneToMany(mappedBy="person")
	private List<Request> requests;

	//bi-directional many-to-many association to Role
//	@ManyToMany(mappedBy="persons")
	@ManyToMany
    @JoinTable(
                  name="USER_ROLE"
                  , joinColumns={
                        @JoinColumn(name="UR_PERSON_ID", referencedColumnName = "PERSON_ID" )
                        }
                  , inverseJoinColumns={
                        @JoinColumn(name="UR_ROLE_ID", referencedColumnName = "ROLE_ID" )
                        }
                  )

	private List<Role> roles;

	//bi-directional many-to-one association to Trade
	@OneToMany(mappedBy="person1")
	private List<Trade> trades1;

	//bi-directional many-to-one association to Trade
	@OneToMany(mappedBy="person2")
	private List<Trade> trades2;

	public Person() {
	}

	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Request> getRequests() {
		return this.requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Request addRequest(Request request) {
		getRequests().add(request);
		request.setPerson(this);

		return request;
	}

	public Request removeRequest(Request request) {
		getRequests().remove(request);
		request.setPerson(null);

		return request;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Trade> getTrades1() {
		return this.trades1;
	}

	public void setTrades1(List<Trade> trades1) {
		this.trades1 = trades1;
	}

	public Trade addTrades1(Trade trades1) {
		getTrades1().add(trades1);
		trades1.setPerson1(this);

		return trades1;
	}

	public Trade removeTrades1(Trade trades1) {
		getTrades1().remove(trades1);
		trades1.setPerson1(null);

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
		trades2.setPerson2(this);

		return trades2;
	}

	public Trade removeTrades2(Trade trades2) {
		getTrades2().remove(trades2);
		trades2.setPerson2(null);

		return trades2;
	}

}