package com.fdmgroup;

import java.util.Map;
import java.util.Set;

public class MainApp {
	
	public static void main(String[] args) {
		GenericClass<Integer, String> gc = new GenericClass<Integer, String>();
		gc.setT(1);
		gc.setX("Alex");
		gc.addNewElement();
		
		gc.setT(2);
		gc.setX("John");
		gc.addNewElement();
		
		gc.setT(3);
		gc.setX("James");
		gc.addNewElement();
		
		gc.setT(4);
		gc.setX("David");
		gc.addNewElement();
		
		Map<Integer, String> map = gc.getMap();
		Set<Integer> keys = map.keySet();
		for ( Integer key : keys){
			System.out.println(key + " " + map.get(key));
		
		}
		System.out.println(countNumberOfElements(keys));
	}
	
	public static <T extends Set> int countNumberOfElements(T set){
			return set.size();
			
	}
}
