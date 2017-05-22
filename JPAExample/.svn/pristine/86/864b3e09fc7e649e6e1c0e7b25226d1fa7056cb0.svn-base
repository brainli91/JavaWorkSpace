package com.fdmgroup.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fdmgroup.util.IDGenerator;

@Entity
@Table(name = "JPA_ROLE")
public class Role {
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	@Id
	private long id;
	
	@Column(name = "Role_name", nullable=false,length =20)
	private String name;
	
	@ManyToMany(mappedBy ="roles")
	private Set<User> users;
	



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Role() {
		super();

	}
	public Role(String name) {
		super();
		this.id = IDGenerator.generate();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [Id=" + id + ", name=" + name + "]";
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
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	
}
