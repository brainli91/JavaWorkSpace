package com.fdmgroup.race;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Race <T extends Driver, X extends Vehicle & FourWheelDrive & Comparable<X>> {
	
	List<T> drivers = new ArrayList<T>();
	Hashtable<T, X> participants = new Hashtable<T, X>();
	
	public boolean addParticipant(T driver, X vehicle){
		if (participants.containsKey(driver)){
			return false;
		}
		else{
			participants.put(driver, vehicle);
			drivers.add(driver);
			return true;
		}
	}
	
	public List<T> getAllDrivers(){
		return drivers;
	}
	
	public T announceTheWinnder(){
		int random = (int)Math.round(Math.random() * (drivers.size() -1 ));
		return drivers.get(random);
	}
	
	

}
