package com.fdmgroup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
		//Calendar cal = null;
		//cal.clear();
		Random rand = new Random();
		int random = rand.nextInt();
		String stArray[] = {"Hello", "World", "!!"};
		if(random >= 0 && random < stArray.length){
			System.out.println(stArray[random]);
		}
		else{
			System.out.println("Not a correct number");
		}
		
		Calculator cal = new Calculator();
		try{
			cal.div(45, 0);
		}
		catch (MyException ex){
			System.out.println(ex.getMessage());
		}
		
		File f = new File("test.txt");
		try {
			FileInputStream fos = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.err.println(e.getMessage());
		} catch (Exception e){
			System.err.println(e.getMessage());
		} finally{
			System.out.println("Finally executed");
		}
		
		System.out.println("Test....");
	}
}
