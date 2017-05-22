package com.fdmgroup.race;

public class SUV extends Vehicle implements FourWheelDrive, Comparable<SUV> {

	public SUV(String model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	public String getType(){
		return "SUV";
	}
	
	public int getNumOfWheels(){
		return 4;
	}
	
	public void accelerate(){
		System.out.println("Acceleration enabled.");
	}
	
	public int compareTo(SUV o){
		return getModel().compareTo(o.getModel());
	}
}
