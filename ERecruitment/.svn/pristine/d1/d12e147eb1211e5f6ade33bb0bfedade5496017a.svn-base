package com.fdmgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.cfg.VerifyFetchProfileReferenceSecondPass;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.fdmgroup.dao.ApplicantProfileDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.ApplicantProfile;
import com.fdmgroup.model.Interview;
import com.fdmgroup.model.User;

public class InterviewControllerTest {

  @Mock
  UserDAO userDAO;

  @Mock
  Model model;

  @Mock
  Set<Interview> setOfInterviews;

  @Mock
  Mock mock;
  
  @Mock
  User user;


  @InjectMocks
  InterviewController interviewController;
  

  @Before
  public void setUp() throws Exception {

    interviewController = new InterviewController();
    initMocks(this);

  }


  /*
  @Test
  public void testProcessRegisterBRFail() {
  	when(br.hasErrors()).thenReturn(true);
  	String response = registrationController.processRegistration(model, user, br);
  	assertEquals("register", response);
  	verify(userDAO, never()).create(any(User.class));
  }*/

}
