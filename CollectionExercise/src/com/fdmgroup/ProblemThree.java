package com.fdmgroup;
import java.awt.Color;
import java.util.HashMap;

public class ProblemThree {
	
	public static HashMap<String,Color> FindColor(){
		
		HashMap<String, Color> colorMap = new HashMap<String,Color>();
		
		String[] predefinedColor ={ 
			"yellow","blue", "cyan", "darkGray", 
			"orange", "green", "red", "lightGray", 
			"magenta", "black", "gray","white", 
			"pink" };
		
		Color[] colorObject ={
		Color.yellow, Color.blue,Color.cyan,Color.darkGray,
		Color.orange, Color.green,Color.red,Color.lightGray,
		Color.magenta, Color.black,Color.gray,Color.white,
		Color.pink};
	
	
		for(int i =0; i<predefinedColor.length; i++ ){
			colorMap.put(predefinedColor[i], colorObject[i]);
		}
	
		return colorMap;
		
	}
	
	
}
