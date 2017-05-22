package com.fdmgroup.fileiotddwalthrough.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.fdmgroup.fileiotddwalthrough.controller.RegistrationController;
import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;
import com.fdmgroup.fileiotddwalthrough.io.WriteCommand;

import static org.mockito.Mockito.*;

public class RegistrationControllerTest {

	private UserFactory mockUserFactory;
	private RegistrationController regController;
	private WriteCommand mockWriteCommand;
	private User mockUser;
	private String testUsername;
	private String testPassword;
	private String testRole;

	@Before
	public void setup() {
		mockUserFactory = mock(UserFactory.class);
		mockWriteCommand = mock(WriteCommand.class);
		mockUser = mock(User.class);
		regController = new RegistrationController(mockUserFactory, mockWriteCommand, null);
		testUsername = "testUsername";
		testPassword = "testPassword";
		testRole = "testRole";
	}

	@Test
	public void test_registerUser_CallsCreateUserMethodOfUserFactory_PassingInputStrings() {
		// Arrange
		// Act
		regController.registerUser(testUsername, testPassword, testRole);
		// Assert
		verify(mockUserFactory, times(1)).createUser(testUsername, testPassword, testRole);
	}

	@Test
	public void test_registerUser_CallsWriteMethodOfWriteCommandPassingAUser_WhenCaller() {
		// Arrange - All done in setup
		// Act
		regController.registerUser(testUsername, testPassword, testRole);
		// Assert
		verify(mockWriteCommand, times(1)).write(any(User.class));
	}

	@Test
	public void test_RegisterUser_CallsWriteMethodOfWriteCommandPassingTheUserReturendToItFromUserFactory_WhenCalled() {
		// because the mock will return null but I need it to return one object
		when(mockUserFactory.createUser(testUsername, testPassword, testRole)).thenReturn(mockUser);
		// Act
		regController.registerUser(testUsername, testPassword, testRole);
		// Assert
		verify(mockWriteCommand, times(1)).write(mockUser);
	}

}
