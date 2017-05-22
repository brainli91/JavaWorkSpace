package com.fdmgroup.auth;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PasswordHashTest {

	PasswordHash hash;
	
	
	
	@Before
	public void setup(){
		hash = new PasswordHash();
		
	}
	
	@Test
	public void testHash() {
		String password1 = "password";
		String hashedPassword1 = hash.hash(password1);
		
		String hashedPassword2 = hash.hash(password1);
		assertNotEquals(hashedPassword1, hashedPassword2);
		
	}

	@Test
	public void testVerifyPassword() {
		String password1 = "password";
		String hashedPassword1 = hash.hash(password1);
		
		assertTrue(hash.verifyPassword(hashedPassword1, password1));
		
		
	}

}
