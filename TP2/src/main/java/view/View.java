package com.fdm.tp.view;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.fdm.tp.main.Start;
import com.fdm.tp.model.factories.UserFactory;
import com.fdm.tp.model.storable.User;

public class View implements IView{
	Scanner scanner;
	 static Logger log = Logger.getLogger(Start.class.getName());
	String parameters[] = {"username",
		"password",
		"first Name",
		"last name",
		"set role of the user (enter 1 for regular user)"};
	String[] inputData = new String[5];
	
	public View(Scanner scanner) { 
		this.scanner = scanner;
	}
	
	
	public User getUser() {
		log.debug("creating user using input...");
		User user = UserFactory.createUser();
		 String str1;
		
		    for(int i = 0; i <= parameters.length-1;i++){
		    System.out.println("Please Enter" + parameters[i]+":");
		    str1 = scanner.nextLine();
		    
		    inputData[i] = str1;
		    }
		    
		    user.setUserName(inputData[0]); 
		    user.setPassword(inputData[1]);
		    user.setFirstName(inputData[2]);
		    user.setLastName(inputData[3]);
		    Integer int1 = Integer.valueOf(inputData[4]);
		    user.setRole(int1);
			
		    return user;
	}

	public void displayMessage(String message) {
//		System.out.println("## your new user is: "+user.getUserName());
//		//System.out.println("## and his password is: "+user.getPassword());
//		System.out.println("## user's first name is: "+user.getFirstName());
//		System.out.println("## user's last name is: "+user.getLastName());
//		//System.out.println("##boolean is: "+user.isEnable());
//		System.out.println("## and user's role is: "+user.getRole())
		System.out.println(message);
	}

}
