package com.fdmgroup.race;

import java.util.List;

public class RaceApp {

	public static void main(String[] args) {
		Driver d1 = new Driver("Alex", "1354564", 25);
		Driver d2 = new Driver("William", "78846526", 32);
		Driver d3 = new Driver("Frank", "8512312", 20);
		Driver d4 = new Driver("Henry", "9451213", 28);
		Driver d5 = new Driver("James", "231587496", 30);
		
		SUV suv1 = new SUV("RDX");
		SUV suv2 = new SUV("MDX");
		SUV suv3 = new SUV("Q5");
		SUV suv4 = new SUV("X5");
		SUV suv5 = new SUV("S6");
		
		Race<Driver, SUV> race = new Race<Driver, SUV>();
		
		race.addParticipant(d1, suv1);
		race.addParticipant(d2, suv2);
		race.addParticipant(d3, suv3);
		race.addParticipant(d4, suv4);
		race.addParticipant(d5, suv5);
		
		System.out.println(race.announceTheWinnder());
		System.out.println("------------------------");
		//System.out.println(countNumberOfParticipants());
	}
	
	public static <T extends List<? extends Driver>> int countNumberOfParticipants(T drivers){
		for (Driver driver : drivers) {
			System.out.println("driver");
		}
		return drivers.size();
	}
}
