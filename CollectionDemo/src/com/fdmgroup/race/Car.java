package com.fdmgroup.race;

public class Car extends Vehicle{

	public Car(String model) {
		super(model);
		// TODO Auto-generated constructor stub
	}
	public int getNumOfWheels(){

		return 4;
	}
	
	public String getType(){
		return "Car";
	}
}
