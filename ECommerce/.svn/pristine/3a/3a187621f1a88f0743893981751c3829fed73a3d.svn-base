package com.fdmgroup.entity;

import java.io.Serializable;
import java.util.HashMap;

/*import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;*/

/*@Entity
@Table(name = "EC_USERS")
@NamedQueries({ @NamedQuery(name = "user.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "user.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username") })
*/
public class User implements IStorable, Serializable {

	/*
	 * @Id
	 * 
	 * @Column(name = "user_id", nullable = false)
	 * 
	 * @SequenceGenerator(name = "er_user_sequence", sequenceName =
	 * "ER_USERS_SEQ", allocationSize = 1)
	 * 
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "er_user_sequence")
	 */
	private Integer id;

	// @Column(name = "user_name", nullable = false)
	private String username;

	// @Column(name = "pw", nullable = false)
	private String password;

	// @Column(name = "first_name", nullable = false, length = 32)
	private String firstName;

	// @Column(name = "last_name", nullable = false, length = 32)
	private String lastName;

	// @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Basket basket;

	
	private HashMap<Integer, Integer> itemsCount;
	
	
	public HashMap<Integer, Integer> getItemsCount() {
		return itemsCount;
	}

	public void setItemsCount(HashMap<Integer, Integer> itemsCount) {
		this.itemsCount = itemsCount;
	}

	
	public User() {
		super();
	}




	public User(Integer id, String username, String password, String firstName, String lastName, Basket basket,
			HashMap<Integer, Integer> itemsCount) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.basket = basket;
		this.itemsCount = itemsCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", basket=" + basket + ", itemsCount=" + itemsCount + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
