package com.fdmgroup.tradingplatform.bin;

public class SecurityRole {

	private int personId;
	private String userName;
	private int roleId;
	
	public SecurityRole(int personId, String userName, int roleId) {
		super();
		this.personId = personId;
		this.userName = userName;
		this.roleId = roleId;
	}

	public int getPersonId() {
		return personId;
	}
	
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "SecurityRole [personId=" + personId + ", userName=" + userName + ", roleId=" + roleId + "]";
	}
	
	
}


