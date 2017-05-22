package com.fdmgroup;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;


public class ProblemSix {

	
	public static LinkedList<String> ReversedList(LinkedList <String> list){
		LinkedList<String> reverseList = new LinkedList<String>();
		
		ListIterator <String> iterator = list.listIterator(list.size());
		while (iterator.hasPrevious()) {
			reverseList.add(iterator.previous());
			
		}
			
		
		return reverseList;
		
	}

}
