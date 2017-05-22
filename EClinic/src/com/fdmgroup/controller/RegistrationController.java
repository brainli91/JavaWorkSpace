package com.fdmgroup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.fdmgroup.auth.PasswordHash;
import com.fdmgroup.dao.ProfileDAO;
import com.fdmgroup.dao.RoleDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.entity.Profile;
import com.fdmgroup.entity.Role;
import com.fdmgroup.entity.User;

@Controller
public class RegistrationController {

@Autowired
ApplicationContext appContext;

@Autowired
@Qualifier("password")
PasswordHash passwordHash;

@Autowired
@Qualifier("userDAO")
UserDAO userDAO;

@Autowired
@Qualifier("roleDAO")
RoleDAO roleDAO;

@Autowired
@Qualifier("profileDAO")
ProfileDAO profileDAO;

@RequestMapping(value="/register", method = RequestMethod.GET)
public String registrationForm(Model model){
	model.addAttribute("registerUser", new User());
	return "register";
}

@RequestMapping(value="/register", method = RequestMethod.POST)
public String processRegistration(Model model, @Valid User registerUser,SessionStatus ss, BindingResult br){
	model.addAttribute("registerUser",registerUser);
	
	if (br.hasErrors()) {
		StringBuilder errors = new StringBuilder();
		br.getFieldErrors().stream().map(e -> "<li>" + e.getField() + " " + e.getDefaultMessage() + "</li>").forEach(errors::append);
		model.addAttribute("errorMsg", errors.toString());
		return "register";
	}
	
	if (userDAO.findByEmail(registerUser.getEmail()) != null) {
		model.addAttribute("errorMsg", "Email Account has been taken");
		return "register";
	} else{
		Profile profile = new Profile();
		Role role = roleDAO.findByName("patient");
		
		registerUser.setPassword(passwordHash.hash(registerUser.getPassword()));
		registerUser.setActive(1);
		registerUser.setRole(role);
		profile.setUser(registerUser);
		profileDAO.create(profile);
		User loginUser = new User();
		loginUser.setEmail(registerUser.getEmail());
		model.addAttribute("loginUser", loginUser);
		return "login";
	}	
}


public ApplicationContext getAppContext() {
	return appContext;
}

public void setAppContext(ApplicationContext appContext) {
	this.appContext = appContext;
}

public PasswordHash getPasswordHash() {
	return passwordHash;
}

public void setPasswordHash(PasswordHash passwordHash) {
	this.passwordHash = passwordHash;
}

public UserDAO getUserDAO() {
	return userDAO;
}

public void setUserDAO(UserDAO userDAO) {
	this.userDAO = userDAO;
}




	






}
