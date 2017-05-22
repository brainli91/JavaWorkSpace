package com.fdmgroup;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CountCharacter {
	
	public static void main(String[] args) {
		

		//Questions 1
		System.out.println(CountCharacter("C:/Users/Brian.li/JavaWorkspace/IOExercise/files/file1.txt", 's'));

		
	}
	
	public static int CountCharacter(String file, char c) {
		
		int count = 0;
		FileReader reader = null;
		BufferedReader br = null;
		
		try{
		

		br = new BufferedReader(reader= new FileReader(file));
		
		String line ="";
	
		while ((line = br.readLine()) != null){
			for (char nc : line.toCharArray()){
				if (nc == c){
					count ++;
				}				
			}
		}
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			closeStream(reader);
			closeStream(br);
			}
		
		return count;
	}
	
	private static Object tochars(String thisLine) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void closeStream(Closeable  closeable) {
		if (closeable != null){
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	


}