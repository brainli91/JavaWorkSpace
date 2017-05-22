package com.fdmgroup.model;

import javax.persistence.Embeddable;


@Embeddable
public class Profile {

	private String firstName;
	private String latsName;
	private String address;
	
	
	public Profile() {
		super();
	}
	
	public Profile(String firstName, String latsName, String address) {
		super();
		this.firstName = firstName;
		this.latsName = latsName;
		this.address = address;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLatsName() {
		return latsName;
	}
	public void setLatsName(String latsName) {
		this.latsName = latsName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Profile [firstName=" + firstName + ", latsName=" + latsName
				+ ", address=" + address + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((latsName == null) ? 0 : latsName.hashCode());
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
		Profile other = (Profile) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (latsName == null) {
			if (other.latsName != null)
				return false;
		} else if (!latsName.equals(other.latsName))
			return false;
		return true;
	}

	
	
}
