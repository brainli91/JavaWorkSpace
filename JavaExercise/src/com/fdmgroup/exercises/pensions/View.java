package com.fdmgroup.exercises.pensions;

public class View {
	
	public void printEligible(Person person){
		System.out.println(person.getFirstname()+ " "+ person.getLastname()+ " " +"may qualify gor a pwnsion this year.");
	}

	public void printIneligible(Person person){
		System.out.println(person.getFirstname()+ " "+ person.getLastname()+ " " +"is not old enough yet.");
		
		
	}
}