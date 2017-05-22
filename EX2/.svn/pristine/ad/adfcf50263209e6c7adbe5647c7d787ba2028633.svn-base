package commands;

import interfaces.ICommand;

import java.util.Scanner;

import org.apache.log4j.Logger;

import userManager.UserActions;
import dto.Person;
import exceptions.InvalidInputException;
import exceptions.NoUserException;

public class LoginCommand implements ICommand{
	
	Person temp;
	Person potentialUser;
	UserActions useractions = new UserActions();
	private String username, password;
	
	public LoginCommand(String usrename, String password){
		this.username = username;
		this.password = password;
	}
	
	@Override
	public void execute() {
	
	
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter a username");
//		String username = scanner.nextLine();
//		System.out.println("Enter your password");
//		String password = scanner.nextLine();
//		
		
		
		try {
			useractions.Login(username, password);
		} catch (NoUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

		
//		try {
//			useractions.Login(username, password);
//			throw new UsernamePasswordMismatchException("Username and password do not match.");
//		} catch (NoUserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UsernamePasswordMismatchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
		
		
	}
	
	static Logger log = 
			Logger.getLogger(InvalidInputException.class);

}
