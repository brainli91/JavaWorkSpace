package com.fdmgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.fdmgroup.auth.PasswordHash;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.User;

public class LoginControllerTest {

  @Mock
  UserDAO userDAO;
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
  LoginController loginController;

  String email = "test@test.com";

  @Before
  public void setup() {
    loginController = new LoginController();
    initMocks(this);
    when(br.hasErrors()).thenReturn(false);
    when(user.getPassword()).thenReturn("password");
    when(foundUser.getPassword()).thenReturn("hashed password");
    when(user.getEmail()).thenReturn(email);
    when(userDAO.findByEmail(email)).thenReturn(foundUser);
    when(passwordHash.verifyPassword("hashed password", "password")).thenReturn(true);

  }

  @Test
  public void testProcessLoginSuccess() {
    String response = loginController.processLogin(model, user, br, null);
    assertEquals("redirect:dashboard", response);
  }

  @Test
  public void testProcessLoginPWFail() {
    when(passwordHash.verifyPassword("hashed password", "password")).thenReturn(false);
    String response = loginController.processLogin(model, user, br, null);
    assertEquals("login", response);
  }

  @Test
  public void testProcessLoginBRFail() {
    when(br.hasErrors()).thenReturn(true);
    String response = loginController.processLogin(model, user, br, null);
    assertEquals("login", response);
  }

}
