package com.fdmgroup;


public abstract class RentHouse {

	String description = "Unkown";
	
	public String getDescription(){
		return description;
	}
	
	public abstract double rentCost();
	
}