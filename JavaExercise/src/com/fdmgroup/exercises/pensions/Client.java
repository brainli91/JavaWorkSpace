package com.fdmgroup.exercises.pensions;


public class Client {

	public static void main(String[] args) {
		PensionController pension = new PensionController();
		pension.handlePensions(makePeople());
	}
	
		
	public static Person[] makePeople() {
		Person person1 = new Person();
		person1.setFirstname("John");
		person1.setLastname("Smith");
		person1.setDataOfBirth("28/06/1993");
		
		Person person2 = new Person();
		person2.setFirstname("Jane");
		person2.setLastname("Doe");
		person2.setDataOfBirth("05/01/1950");
				
		Person person3 = new Person();
		person3.setFirstname("Fred");
		person3.setLastname("Bloggs");
		person3.setDataOfBirth("12/12/1949");
				
		Person[] people = {person1, person2, person3};
		return people;
	}

}