package com.fdm.tp.util;


import static org.mockito.Mockito.verify;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdm.tp.controller.IController;
import com.fdm.tp.model.storable.User;
import com.fdm.tp.model.storage.IStorage;


public class ActionRegisterUserTest {
	Action_RegisterUser regAc;
	
	@Mock
	User testUser;
	
	@Mock
	IStorage str;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		regAc = new Action_RegisterUser(str);
	}
	
	
	@Test
	public void testAddUserMethodIsCalledWithTheGivenUser() {
			regAc.register(testUser);
			verify(str).addUser(testUser);
	}
	
	@Test
	public void testRegisterMethodReturnsIControllerLoginConstant() {
		Assert.assertEquals(IController.login, regAc.register(testUser));
	}
	

}

//test addUser is called
//test returns IController.login
//test that it creates a new storage with the given str