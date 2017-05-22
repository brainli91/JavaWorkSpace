package com.fdmgroup.fileiotddwalthrough.entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;

public class UserFactoryTest {

	private UserFactory userFactory;
	@Before
	public void setUp(){
		userFactory = new UserFactory();
	}

	@Test
	public void test_CreateUser_ReturnsAnObjectOfTypeUser() {
		User returnedUser = userFactory.createUser("", "", "");
		assertTrue(returnedUser instanceof User);
	}
	
	@Test
	public void test_CreateUser_ReturnsAUserObjectWithUsernameSetToFirstParameterOfCreateUser(){
		User returnedUser = userFactory.createUser("testUsername", "", "");
		assertEquals("testUsername", returnedUser.getUsername());
	}
	
	

}
