package com.fdmgroup;

import java.util.Arrays;
import java.util.TreeSet;

public class ProblemSeven {
	//Write a method that uses a String method split to tokenize a line of text input by the user 
	//and places each token in a TreeSet.  It return the TreeSet. 
	public static TreeSet<String> Tokenize (String senetence){
		String[] splitwords = senetence.replaceAll("\\p{Punct}", " ").toLowerCase().split("\\s+");
		
		TreeSet<String> wordTree = new TreeSet <String>(Arrays.asList(splitwords));
		return wordTree;
		
	}
}
