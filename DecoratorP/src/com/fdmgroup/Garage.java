package com.fdmgroup;


public class Garage extends UtilityDecorator {

	RentHouse rentHouse;
	
	public Garage(RentHouse rentHouse) {
		this.rentHouse = rentHouse;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return rentHouse.getDescription() + ", Garage";
	}

	@Override
	public double rentCost() {
		// TODO Auto-generated method stub
		return rentHouse.rentCost() + 150;
	}

}