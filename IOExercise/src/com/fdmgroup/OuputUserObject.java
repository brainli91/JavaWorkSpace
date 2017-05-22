package com.fdmgroup;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class OuputUserObject {
	 public static void main(String[] args) {
		List <User> users = ReadUserData("C:/Users/Brian.li/Desktop/Users.txt");
		for (User user:users){
			System.out.println(user);
		}
	}
	
	static List<User> users= new ArrayList();
	
	
	public static List<User> ReadUserData (String fileDir){
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(fileDir);
			br = new BufferedReader (fr);
			
			String line ="";
			
			while ((line = br.readLine())!= null){
				String [] infoParts = line.split(",");
				User user = new User (infoParts[0], infoParts[1], infoParts[2]);
				users.add(user);
				}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeStream(fr);
			closeStream(br);
			
			
	}
		return users;
	}
	
	public static void closeStream(Closeable closeable){
		if (closeable!= null){
			try {
				closeable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
