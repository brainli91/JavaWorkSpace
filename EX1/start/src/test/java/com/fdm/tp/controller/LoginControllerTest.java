package com.fdm.tp.controller;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import com.fdm.exceptions.LoginException;
import com.fdm.tp.model.storable.User;
import com.fdm.tp.util.IActions;
import com.fdm.tp.validate.LoginValidator;
import com.fdm.tp.view.LoginView;


public class LoginControllerTest {
	LoginController loginController;
	
	@Mock 
	LoginView view;
	@Mock
	User user;
	@Mock
	LoginValidator logVal;
	
	@Mock
	IActions loginAction;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		loginController = new LoginController(view, logVal,loginAction);
	}
	  
	@Test
	public void testMethodGetUserIsCalledFromView(){
		loginController.handle();
		verify(view).getUser();
	}
	
	@Test
	public void testValidateIsCalledFromValidatorWithTheUserFromView() throws LoginException{
		when(view.getUser()).thenReturn(user);
		loginController.handle();

		verify(logVal).validate(user);
	}
	
	@Test
	public void testLoginMethodIsCalledFromActionLoginWhenUserIsValid() throws LoginException{
		user = new User();
		when(view.getUser()).thenReturn(user);
		loginController.handle();
		verify(loginAction).executeAction(user);
	}
		
	@Test
	public void testLoginMethodIsNotCalledFromActionLoginWhenUserIsInValid() throws LoginException{
		
		when(view.getUser()).thenReturn(user);
		doThrow(new LoginException("")).when(logVal).validate(user);
		
		loginController.handle();

		verify(loginAction, never()).executeAction(user);
	}
 
	@Test
	public void testHandleMethodReturnsTheSameIntAsExecuteMethod(){
		when(view.getUser()).thenReturn(user);
		when(loginAction.executeAction(user)).thenReturn(IController.login);
		
		//loginController.handle();
		Assert.assertEquals(IController.login, loginController.handle());
	}
	
	
	//test1 make sure getUser is called from view
	//test2 make sure validate is called from the validator, with the user returned from the view
	//test3 make sure loginrUser is called from login when user is valid
	//test4 make sure loginUser is not called when user fails validation
	//test5 make sure handle returns the same int that was returned by login user
}
