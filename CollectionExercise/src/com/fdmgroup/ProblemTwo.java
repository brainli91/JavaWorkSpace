package com.fdmgroup;

import java.util.TreeSet;

public class ProblemTwo {
	
	private static TreeSet<String> ts = new TreeSet<String>();
	
	public static TreeSet<String> EliminateDuplicate (String...names) {
		
		for (String s : names){
			ts.add(s);
		}
		return ts;
	}
	
}
