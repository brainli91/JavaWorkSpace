package com.fdmgroup.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.*;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.fdmgroup.dao.ApplicantProfileDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.ApplicantProfile;
import com.fdmgroup.model.User;

public class ProfileControllerTest {

  @Mock
  UserDAO userDAO;

  @Mock
  Model model;

  @Mock
  ApplicantProfileDAO applicantProfileDao;

  @Mock
  HttpSession session;

  @Mock
  User user;

  @Mock
  BindingResult br;

  @Mock
  ApplicantProfile profile;

  @InjectMocks
  ProfileController profileController;

  String email = "test@test.com";

  @Before
  public void setUp() throws Exception {

    profileController = new ProfileController();
    initMocks(this);
    when(br.hasErrors()).thenReturn(false);
    when(session.getAttribute("user")).thenReturn(user);
    when(user.getApplicantProfile()).thenReturn(null);

  }

  @Test
  public void testShowProfileWhenDoesNotExist() {
    String view = profileController.showProfileForm(model, user);
    assertEquals("profile_form", view);
    ApplicantProfile profile = new ApplicantProfile();
    verify(model).addAttribute("applicantProfile", profile);

  }

  @Test
  public void testShowProfileWhenExist() {
    ApplicantProfile profile = new ApplicantProfile(user, "On", "1235", "12365", "absahhsadkbg",
        "skills", null, null);
    when(user.getApplicantProfile()).thenReturn(profile);
    String view = profileController.showProfileForm(model, user);
    assertEquals("profile_form", view);
    verify(model).addAttribute("applicantProfile", profile);

  }

  @Test
  public void testCreateProfileWhenNotExist() {
    ApplicantProfile profile = new ApplicantProfile(user, "On", "1235", "12365", "absahhsadkbg",
        "skills", null, null);
    when(user.getApplicantProfile()).thenReturn(null);
    when(applicantProfileDao.create(profile)).thenReturn(profile);
    String view = profileController.editProfile(model, user, profile, br);
    assertEquals("profile", view);
    // verify(model).addAttribute("profile" , profile);

  }

  @Test
  public void viewApplicantProfileGoodID() {
    when(applicantProfileDao.read(1)).thenReturn(profile);
    String view_applicant = profileController.viewApplicantProfile(model, user);
    assertEquals("view_applicant", view_applicant);
    verify(model).addAttribute("applicant", user);
  }

  @Test
  public void viewApplicantProfileBadID() {
    // when(applicantProfileDao.read(1)).thenReturn(new ApplicantProfile()); //simulate a
    // bad id
    String view_applicant = profileController.viewApplicantProfile(model, "500jryhryfjnh");
    assertEquals("view_applicant", view_applicant);
    verify(model).addAttribute("applicant", null);
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
