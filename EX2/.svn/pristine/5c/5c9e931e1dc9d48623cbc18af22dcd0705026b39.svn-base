package entities;

import java.io.Serializable;

import javax.persistence.*;

import dto.IStorable;

import java.util.List;


/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name="\"ROLE\"")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable, IStorable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLE_ID")
	private long roleId;

	@Column(name="ROLE_NAME")
	private String roleName;

	//bi-directional many-to-many association to Person
	@ManyToMany
	@JoinTable(name="USER_ROLE",
	 joinColumns={@JoinColumn(name="UR_ROLE_ID")}
	, inverseJoinColumns={
		@JoinColumn(name="UR_PERSON_ID")
	}
	)

	
	private List<Person> persons;

	public Role() {
	}

	public long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}