package com.fdmgroup;

public class Gym extends UtilityDecorator {

	RentHouse rentHouse;
	
	public Gym(RentHouse rentHouse) {
		this.rentHouse = rentHouse;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return rentHouse.getDescription() + ", Gym";
	}

	@Override
	public double rentCost() {
		// TODO Auto-generated method stub
		return rentHouse.rentCost() + 100;
	}
	
	
}