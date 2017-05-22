package com.fdm.tp.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class ControllerFactoryTest {
	ControllerFactory factory;
	
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this); //probably dont need this
		factory = new ControllerFactory();
	}
	
	@Test
	public void testIControllerStartConstantReturnsAStartControllerObject() {
		 IController startController = factory.create(IController.start);
	     assertEquals(StartController.class, startController.getClass());
		
	}
	
	@Test
	public void testIControllerRegisterConstantReturnsARegistrationControllerObject() {
		 IController regController = factory.create(IController.register);
		assertEquals(RegistrationController.class, regController.getClass());
	}
	
	@Test
	public void testIControllerLoginConstantReturnsALoginControllerObject() {
		 IController loginController = factory.create(IController.login);
		assertEquals(LoginController.class, loginController.getClass());
	}


	
}
