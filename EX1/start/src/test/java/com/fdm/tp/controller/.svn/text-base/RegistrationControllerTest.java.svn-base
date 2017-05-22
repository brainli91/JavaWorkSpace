package com.fdm.tp.controller;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;




import com.fdm.exceptions.RegistrationException;
import com.fdm.tp.model.storable.User;
import com.fdm.tp.util.IActions;
import com.fdm.tp.validate.RegistrationValidator;
import com.fdm.tp.view.View;
public class RegistrationControllerTest {

	RegistrationController regController;
	@Mock 
	View view;
	@Mock
	User user;
	@Mock
	RegistrationValidator regVal;
	
	@Mock
	IActions registerAction;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		regController = new RegistrationController(view, regVal,registerAction);
	}
	  
	@Test
	public void testMethodGetUserIsCalledFromView(){
		regController.handle();
		verify(view).getUser();
	}
	
	@Test
	public void testValidateIsCalledFromValidatorWithTheUserFromView() throws RegistrationException{
		when(view.getUser()).thenReturn(user);
		regController.handle();

		verify(regVal).validate(user);
	}
	
	@Test
	public void testRegisterMethodIsCalledFromActionRegisterWhenUserIsValid() throws RegistrationException{
		when(view.getUser()).thenReturn(user);
		regController.handle();
		verify(registerAction).executeAction(user);
	}
		
	@Test
	public void testRegisterMethodIsNotCalledFromActionRegisterWhenUserIsInValid() throws RegistrationException{
		
		when(view.getUser()).thenReturn(user);
		doThrow(new RegistrationException("")).when(regVal).validate(user);
		
		regController.handle();

		verify(registerAction, never()).executeAction(user);
	}
 
	@Test
	public void testHandleMethodReturnsTheSameIntAsExecuteMethod(){
		when(view.getUser()).thenReturn(user);
		when(registerAction.executeAction(user)).thenReturn(IController.login);
		
		//regController.handle();
		Assert.assertEquals(IController.login, regController.handle());
	}
	
	
	//test1 make sure getUser is called from view
	//test2 make sure validate is called from the validator, with the user returned from the view
	//test3 make sure registerUser is called from register when user is valid
	//test4 make sure registerUser is not called when user fails validation
	//test5 make sure handle returns the same int that was returned by register user
	
}
