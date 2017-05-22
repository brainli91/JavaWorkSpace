package com.fdmgroup;

import java.util.ArrayList;


public class App {
	public static void main(String[] args) {
		
		ArrayList<Machine>list1 = new ArrayList <Machine>();
		
		list1.add(new Machine());
		list1.add(new Machine());
	
		showList(list1);
		
		ArrayList<Camera>list2 = new ArrayList <Camera>();
		
		list2.add(new Camera());
		list2.add(new Camera());
		
		showList(list2);

	}
	
	
	public static void showList(ArrayList<? extends Machine> list){
		
		for (Machine value : list){
			System.out.println(value);
			value.start();
			
		}
		
		
	}

}
