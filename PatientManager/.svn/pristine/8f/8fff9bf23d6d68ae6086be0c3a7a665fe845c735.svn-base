package com.fdmgroup.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import com.fdmgroup.entity.Role;
import com.fdmgroup.entity.User;

public class UserDAOTest {

	@Mock
	Role role;
	
	static DBConnection dbConnection = new DBConnection();
	static UserDAO userDAO = new UserDAO();
	
	User userA, userB, userC, userD;
	List<User> userList;
	

	
	@BeforeClass
	public static void setUpBeforeClass(){
	userDAO.setDbConnection(dbConnection);	
	}
	
	@Before
	public void setUp(){
		userList = new ArrayList<>();
		userA = new User("123@fdmgroup.com", "12345", "Brian", "Li", role );
		userB = new User("gl@fdmgroup.com", "12345", "George", "Lai", role );
		userC = new User("nabil@fdmgroup.com", "12345", "Nabil", "Khan", role);
		userList.add(userA);
		userList.add(userB);
		userList.add(userC);
	}
	
	
	@Test
	@Ignore
	public void createTest(){
		User createdUser = userDAO.create(userA);
		assertEquals(userA, createdUser);
	}
	
	@Test
	@Ignore
	public void readTest(){
		User createdUser = userDAO.create(userC);
		User expectedUser = userDAO.read(userC.getId());
		assertEquals(expectedUser, createdUser);
	}
	
	@Test
	@Ignore
	public void updateTest(){
		System.out.println(userA);
		User createdUser = userDAO.create(userA);
		userA.setFirstName("Nick");
		User updatedUser = userDAO.update(userA);
		System.out.println(updatedUser);

		assertTrue(userA.getFirstName().equals("Nick"));
	}
	
	@Test
	@Ignore
	public void deleteTest(){
		User createdUser = userDAO.create(userA);
		//System.out.println(userA.getActive());
		userDAO.delete(createdUser);
	//	System.out.println(userA.getActive());
		assertEquals(createdUser.getActive(), 0);
	}
	
	@Test
	@Ignore
	public void findAllTest(){
		userDAO.create(userA);
		userDAO.create(userB);
		userDAO.create(userC);
		List<User> users = userDAO.findAll();
		System.out.println(userList);
		System.out.println(users);
		
		assertEquals(userList, users);
	}
	
	@Test
	public void findByEmail(){
		userDAO.create(userB);
		User user = userDAO.findByEmail(userB.getEmail());
		System.out.println(userB);
		System.out.println(user);
		assertEquals(user, userB);
	}
	
	@Test
	public void findByFirstName(){
		userDAO.create(userC);
		List<User> users = userDAO.findByFirstName(userC.getFirstName());
		System.out.println(users);
		System.out.println(userC);
		assertTrue(users.contains(userC));
	}
	
	@Test
	public void findByLastName(){
		userDAO.create(userA);
		List<User> users = userDAO.findByFirstName(userA.getFirstName());
		System.out.println(users);
		System.out.println(userA);
		assertTrue(users.contains(userA));
	}
}
