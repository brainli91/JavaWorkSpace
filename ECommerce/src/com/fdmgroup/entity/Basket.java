package com.fdmgroup.entity;

import java.io.Serializable;

/*import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
*/


/*@Entity
@Table(name = "EC_BASKETS")
@NamedQueries({
    @NamedQuery(name = "basket.findByUserId", query = "SELECT ba FROM Basket ba WHERE ba.user.id= :uId")})
*/public class Basket implements IStorable,Serializable{

	private static final long serialVersionUID = 1L;
//	@Id
//	@Column(name = "basket_id", nullable = false)
	private Integer id;
	
	private User user;
	
	private Item item;
	
	private Integer count;
	

	public Basket() {
		super();
	}
	
	

	
	public Basket(Integer id, User user, Item item, Integer count) {
		super();
		this.id = id;
		this.user = user;
		this.item = item;
		this.count = count;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}



	public Integer getCount() {
		return count;
	}


	public void setCount(Integer count) {
		this.count = count;
	}



	@Override
	public String toString() {
		return "Basket [id=" + id + ", user=" + user + ", item=" + item + ", count=" + count + "]";
	}

}
