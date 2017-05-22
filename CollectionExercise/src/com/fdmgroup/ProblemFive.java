package com.fdmgroup;

import java.util.HashMap;

public class ProblemFive {
	//5)	Write a method that returns the number of duplicate words in a sentence. 
	//Treat uppercase and lowercase letters the same. Ignore punctuation

	public static HashMap<String, Integer> CountDuplicate(String sentence){
		HashMap<String, Integer> occurrences = new HashMap<String, Integer>();

		
		String[] splitWords =  sentence.replaceAll("\\p{Punct}", " ").toLowerCase().split("\\s+");
		for ( String word : splitWords ) {
		   Integer oldCount = occurrences.get(word);
		   if ( oldCount == null ) {
		      oldCount = 0;
		   }
		   
			  occurrences.put(word, oldCount + 1);
		
		}
		

		
		return occurrences;
	}
	

}
