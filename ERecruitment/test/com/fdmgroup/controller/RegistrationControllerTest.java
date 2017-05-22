package com.fdmgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.fdmgroup.auth.PasswordHash;
import com.fdmgroup.dao.ApplicantProfileDAO;
import com.fdmgroup.dao.RoleDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.User;

public class RegistrationControllerTest {


	@Mock
	UserDAO userDAO;
	@Mock
	RoleDAO roleDAO;
	@Mock
	ApplicantProfileDAO applicantProfileDAO;
	@Mock
	Model model;
	@Mock
	User user;
	@Mock
	User foundUser;
	@Mock
	BindingResult br;
	@Mock
	PasswordHash passwordHash;
	
	@InjectMocks
	RegistrationController registrationController;
	
	String email = "test@test.com";
	
	@Before
	public void setUp() throws Exception {
		registrationController = new RegistrationController();
		initMocks(this);
		when(br.hasErrors()).thenReturn(false);
		when(user.getEmail()).thenReturn(email);
		when(userDAO.findByEmail(email)).thenReturn(null);
	
	}

	@Test
	public void testRegistrationSucess() {
		String register = registrationController.processRegistration(model, user, br);
		assertEquals("login", register);
	}
	
	@Test
	public void testRegisterUsernameAlreadyExists() {
		when(userDAO.findByEmail(email)).thenReturn(foundUser);
		String register = registrationController.processRegistration(model, user, br);
		assertEquals("register", register);
		verify(model).addAttribute("errorMsg", "Email already exists.");
		verify(userDAO, never()).create(any(User.class));
	}
	
	@Test
	public void testProcessRegisterBRFail() {
		when(br.hasErrors()).thenReturn(true);
		String response = registrationController.processRegistration(model, user, br);
		assertEquals("register", response);
		verify(userDAO, never()).create(any(User.class));
	}
	

}
