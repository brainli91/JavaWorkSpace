package com.fdmgroup.exercises.pensions;

public class PensionController {

	public void handlePensions (Person[] people){
		
		PensionLogic pensionable = new PensionLogic();
		View eligiable = new View();
		
		for( int i =0; i < people.length; i++){
			if (pensionable.isPensionable (people[i],"2016")){
				eligiable.printEligible(people[i]);
			}
			
			else {
				eligiable.printIneligible(people[i]);
			}
		}
		
		
		
	}
}
