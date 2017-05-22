package com.fdmgroup.tradingplatform.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.spy;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;

public class UserTest {
	
	@Spy
	 static User testUser;
	 
	@BeforeClass
	public static void setUp() {
		testUser = spy (User.class);
		testUser.setUserName("user1");
		testUser.setPassWord("12345");
		testUser.setFirstName("george");
		testUser.setLastName("yu");
		

	}

	@Test
	public void testGetUsernameReturnsAString() {
		assertEquals("user1", testUser.getUserName());
		assertEquals("12345", testUser.getPassWord());
		assertEquals("george", testUser.getFirstName());
		assertEquals("yu", testUser.getLastName());
	}

}

