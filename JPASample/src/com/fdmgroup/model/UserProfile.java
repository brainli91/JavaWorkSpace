package com.fdmgroup.model;

import javax.persistence.Embeddable;

@Embeddable
public class UserProfile {
	
	private String address;
	
	private String phone;
	
	private int age;

	public UserProfile() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserProfile(String address, String phone, int age) {
		super();
		this.address = address;
		this.phone = phone;
		this.age = age;
	}


	@Override
	public String toString() {
		return "UserProfile [address=" + address + ", phone=" + phone + ", age=" + age + "]";
	}
	
	
	

	
	
}
