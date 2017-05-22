package com.fdmgroup.exercises.pensions;

public class PensionLogic {
	public boolean isPensionable (Person person, String year){
	int birthYear = Integer.parseInt(person.getDataOfBirth().substring(6));
	int currentYear = Integer.parseInt(year);
	
	int age = currentYear - birthYear;
	
	if (age >=65){
		return true;
	}
	else 
		return false;
	
	}
	
}
