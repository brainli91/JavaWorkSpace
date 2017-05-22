package com.fdmgroup.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PM_ROLE")
@NamedQueries({ 
	@NamedQuery(name = "role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "role.findByName", query = "SELECT r FROM Role r WHERE r.name = :rname"), 
    })
public class Role implements IStorable{
	
	@Id
	@Column(name="role_id")
	private long id;
	
	@Column(name="role_name")
	private String name;
	
	@OneToMany(mappedBy="role")
	private Set<User> users;

	
	public Role() {
		super();
	}

	public Role(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", users=" + users + "]";
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

