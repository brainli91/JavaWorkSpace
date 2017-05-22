package com.fdmgroup;

import java.util.Enumeration;
import java.util.Hashtable;

public class Dictionary {
	private static Hashtable<String, String> dic = new Hashtable<String,String>();
	private static Dictionary dictionary =null;

	private Dictionary() {
		super();
		init();
		
	}
	
	public static Dictionary getInstance(){
		if(dictionary==null)
			dictionary = new Dictionary();
		return dictionary;
		
	}
	private void init() {
		dic.put("Apple","Kind of fruit");
		dic.put("Chair","Something to sit on");
		dic.put("Computer","A device to compute complicated things");
		dic.put("Apple","A company somewhere in California");
		
		
	}
	
	public  String define(String word){
		if (dic.containsKey(word)){
			return dic.get(word);
			
		}
		return "Word not found";
	}
	
	public  boolean addToDictionary(String word,String definition, boolean overwrite){
		
		if(overwrite && dic.contains(word))
			return false;
		
		else{

			dic.put(word,definition);
			return true;
		}
	}
	
	public static void popualteListOfAllEntries(){
		Enumeration<String> keys =dic.keys();
		while(keys.hasMoreElements()){
			String key =keys.nextElement();
			System.out.println(key +" :"+dic.get(key));
		}
	}
	

}
