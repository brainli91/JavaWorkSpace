package com.fdmgroup.tradingplatform.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fdmgroup.tradingplatform.controller.AuthenticationController;
import com.fdmgroup.tradingplatform.model.User;
import com.fdmgroup.tradingplatform.util.TPLogger;

public class MainViewApp {
	
	static User loggedInUser = null; 
	
	public static void main(String[] args) {
		TPLogger.getSystemLogger();
		MainPage();
	}
	static Scanner scanner = new Scanner(System.in);
	static AuthenticationController authc = new AuthenticationController();
	
	public static void MainPage(){
		int action=-1;
		while(action!=0)
		{
			System.out.println("**********************Trading Platform**********************");
			System.out.println("Please select from the following options and press the enter key (0 to exit)\n");
			System.out.println("1) Register");
			System.out.println("2) Login\n");
			System.out.print("Select: ");
			action = scanner.nextInt();
			//scanner.nextLine();
			System.out.println("*************************************************************");
			if (action == 1)
				RegisterPage();
			else if (action == 2)
				LoginPage();
			else
				System.out.println("Exit!");
		}
	}

	private static void LoginPage() {

		System.out.println("*********************** LOGIN ***********************");
		scanner.nextLine();
		System.out.print("Username: ");
		String uname = scanner.nextLine();
		System.out.print("Password: ");
		String pw = scanner.nextLine();
		
		loggedInUser = authc.login(uname, pw);
	}

	private static void RegisterPage() {
		System.out.println("********************* REGISTER *********************");
		List <String> roles = new ArrayList<String>();
		scanner.nextLine();
		System.out.print("Username: ");
		String uname = scanner.nextLine();
		System.out.print("First Name: ");
		String fname = scanner.nextLine();
		System.out.print("Last Name: ");
		String lname = scanner.nextLine();
		System.out.print("Password: ");
		String pw = scanner.nextLine();
	
		int rolenum =-1;
		
		while(rolenum !=0){
			System.out.print("Roles(1-Admin/ 2-Shareholder/ 3-Broker/ 0 - Stop ): ");
			rolenum = scanner.nextInt();
			
			if(rolenum == 1)
				roles.add("admin");
			
			else if(rolenum == 2){
				roles.add("shareholder");
			}
			else if(rolenum == 3){
				roles.add("broker");
			}
			
			
			
		}
		
		authc.registerUser(uname, pw, fname, lname, roles);
		MainPage();
		
	}

}
