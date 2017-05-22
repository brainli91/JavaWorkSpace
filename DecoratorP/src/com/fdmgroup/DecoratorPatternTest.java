package com.fdmgroup;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RentHouse condo = new Condo();
		condo = new Gym(condo);
		condo = new Garage(condo);
		System.out.println(condo.getDescription() + " $" + condo.rentCost() );
		
		
		RentHouse coop = new Coop();
		coop = new Gym(coop);
		coop = new Garage(coop);
		System.out.println(coop.getDescription() + " $" + coop.rentCost() );
		
				
	}

}

