package com.fdmgroup;

import java.util.HashMap;

public class ProblemFour {
	//4)	Write a method to count the number of occurrences of each letter in a string. 
	//For example, the string "HELLO THERE" contains two Hs, three Es, two Ls, one O, 
	//one T and one R. It should return an object that contains the results 
	
	private static HashMap<Character, Integer> count =new HashMap<Character, Integer>();
	
	public static HashMap<Character, Integer> LetterCount (String st){
		
		for(int i =0; i<st.length(); i++){
			char c =st.charAt(i);
			Integer val = count.get(new Character(c));
			
			if (val != null){
				count.put(c, new Integer(val +1));
			}
			
			else {
				count.put(c, 1);
			}
			
		}
		
		
		return count;
		
	}
}
