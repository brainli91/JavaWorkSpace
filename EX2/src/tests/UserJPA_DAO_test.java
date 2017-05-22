package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import jpa.User_DAO_JPA;

import org.junit.Before;
import org.junit.Test;

import entities.Person;
import entities.Role;
import exceptions.StorableNotFoundException;

public class UserJPA_DAO_test {
	
	User_DAO_JPA dao = new User_DAO_JPA();
	Person user1, user2, blankuser;
	Role shareholder = new Role();
	Role role2 = new Role();


	@Before
	public void setup(){
		user1 = new Person(21, "jpalouis", "password", "louis", "yang");
		user2 = new Person(22, "FHLH", "woooooo","Foghorn","Leghorn");
		
		shareholder.setRoleId(1);
		shareholder.setRoleName("Shareholder");

		role2.setRoleId(2);
		role2.setRoleName("role");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(shareholder);
		roles.add(role2);
		user1.setRoles(roles);
		
		user2.setRoles(roles);
		
//		List<Person> persons = new ArrayList<Person>();
//		persons.add(user1);
//		shareholder.setPersons(persons);
		
			
		
	}
	
//	@Test
//	public void testCreate() throws StorableNotFoundException{
//		dao.create(user1);
//	}
	
//	@Test
//	public void testReadIntParam(){
//		try {
//			Person result = dao.read(10);
//			assertTrue(result.getFirstName().equals("Elliot"));
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testReadStringParam(){
//		Person result;
//		try {
//			result = dao.read("JAN");
//			assertTrue(result.getFirstName().equals("Janet"));
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	@Test
	(expected=StorableNotFoundException.class)
	public void testCreateThrowsCorrectException() throws StorableNotFoundException{
		dao.create(blankuser);
	}
	
	@Test
	(expected=StorableNotFoundException.class)
	public void testReadThrowsException() throws StorableNotFoundException{
		Person result = dao.read("JN");
		assertTrue(result.getFirstName().equals("Janet"));
	}
	
	@Test
	public void testDelete() throws StorableNotFoundException{
		try {
			dao.delete(21);
		} catch (StorableNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testDeleteThrowsException() throws StorableNotFoundException{
//		try {
//			dao.delete(100);
//		} catch (StorableNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	@Test
//	public void testUpdate() throws StorableNotFoundException{
//		dao.update(user1, user2);
//	}
	
//	@Test
//	(expected=StorableNotFoundException.class)
//	public void testUpdateThrowsNoUserException() throws StorableNotFoundException{
//		dao.update(null, user1);
//	}

}
