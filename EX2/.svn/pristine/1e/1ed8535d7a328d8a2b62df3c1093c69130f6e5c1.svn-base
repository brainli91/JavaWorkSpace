package tests;

import static org.junit.Assert.*;
import java.sql.Date;

import jpa.User_DAO_JPA;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import userManager.JPAUserActions;
import entities.Person;
import exceptions.StorableNotFoundException;

public class LoginTest {
	
	JPAUserActions actions = new JPAUserActions();
	 Person user1;
 
	Person user3;
	 static User_DAO_JPA dao = new User_DAO_JPA();

//	@Before
//	public void setUp(){
//
//		Person user2 = new Person(22, "FHLH", "woooooo","Foghorn","Leghorn");
//		
//		
//		try {
//			dao.create(user2);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		
//	}
//}
	
	@Test
	public void testLogin(){
		try {
			assertTrue(actions.Login("FHLH", "woooooo").getFirstName().equals("Foghorn"));
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testLoginThrowsException() throws StorableNotFoundException{
//		actions.Login("wrongusername", "password");
//	}
//	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testLoginWrongpasswordThrowsException() throws StorableNotFoundException{
//		actions.Login("FHLH", "wrongpassword");
//	}
}
