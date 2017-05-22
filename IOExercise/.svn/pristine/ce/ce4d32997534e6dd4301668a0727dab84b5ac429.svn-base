package com.fdmgroup;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserStore {
	
	public static void main(String[] args) {
		StoreUserData("C:/Users/Brian.li/Desktop/Users.txt");
		
	}
	public static void StoreUserData(String savePath){
		
		List<User> users = new ArrayList<User>();
		
		Scanner input = new Scanner(System.in);
		int count = 0;
		
		while(true){
			
			String name = null;
			String address = null;
			String email = null;
			String reply =null;
			
			
			
			
			System.out.println("Please Enter the User Information that you want to store");
			System.out.println("-------------------------------------------------------");
			
			System.out.print("Enter Username: ");
			name = input.nextLine();
			
			System.out.print("Enter Address: ");
			address = input.nextLine();
		
			System.out.print("Enter Email: ");
			email = input.nextLine();
			
			User user = new User(name, address, email);
			
			users.add(user); 
			System.out.println("User " + name + " Recored");
			count =count +1;
			
			
			System.out.print("Do you wish to continue(exit by 'q'):");
			reply = input.nextLine();
			
			if (reply.equals("q")){
				System.out.println(count + " user(s) recorded");
				break;
			}
			
		}
		File file = null;
		FileWriter writer =null;
		
		
		try {
			file = new File(savePath);
			file.mkdirs();
			writer = new FileWriter (file, true);
			
			for (User user: users ){
				writer.write(user.getName() +"," +user.getAddress() +","+user.getEmail()+"\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			

			closeStream(writer);
		}
		
		
		
		
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
