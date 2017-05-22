package com.fdm.tp.model.storable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserTest {

	User testUser;
	
	
	@Before
	public void setUp(){
		testUser = new User();
		testUser.setUserName("user1");
		testUser.setPassword("pass");
		testUser.setFirstName("userFirstName");
		testUser.setLastName("userLastName");
		
		
		testUser.setEnable(true);
		testUser.setRole(1);
	}
	
	
	@Test
	public void testGetUsernameReturnsAString(){

		assertEquals("user1", testUser.getUserName());
		assertEquals("pass", testUser.getPassword());
		assertEquals("userFirstName", testUser.getFirstName());
		assertEquals("userLastName", testUser.getLastName());
		
		assertEquals(true, testUser.isEnable());
		assertEquals(1, testUser.getRole());
	}
	
}
