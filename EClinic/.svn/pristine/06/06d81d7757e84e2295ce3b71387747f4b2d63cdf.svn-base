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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fdmgroup.auth.PasswordHash;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.entity.User;

@Controller
@SessionAttributes(names = { "user" }, types = { User.class })
public class LoginController {

  @Autowired
  ApplicationContext appContext;

  @Autowired
  @Qualifier("userDAO")
  UserDAO userDAO;

  @Autowired
  @Qualifier("password")
  PasswordHash passwordHash;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginForm(Model model) {

    model.addAttribute("loginUser", new User());
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String processLogin(Model model, @Valid User loginUser, BindingResult br, SessionStatus ss) {

    if (br.hasErrors()) {
      StringBuilder errors = new StringBuilder();
      model.addAttribute("loginUser", new User());
      br.getFieldErrors().stream().map(e -> "<li>" + e.getField() + " " + e.getDefaultMessage() + "</li>")
          .forEach(errors::append);
      model.addAttribute("errorMsg", errors.toString());
      if (ss != null) {
        ss.setComplete();
      }
      return "login";
    }

    User foundUser = userDAO.findByEmail(loginUser.getEmail());

    if (foundUser != null && passwordHash.verifyPassword(foundUser.getPassword(), loginUser.getPassword())) {
      if (!foundUser.isActive()) {
        String errorMsg = "Your account is disabled. Please contact an administrator.";
        model.addAttribute("errorMsg", errorMsg);
        model.addAttribute("loginUser", new User());
        if (ss != null) {
          ss.setComplete();
        }
        return "login";
      }

      // Successful login
      model.addAttribute("user", foundUser);
      return "redirect:dashboard";
    }

    String errorMsg = "Email/Password is wrong.";
    model.addAttribute("errorMsg", errorMsg);
    model.addAttribute("loginUser", new User());
    if (ss != null) {
      ss.setComplete();
    }
    return "login";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String processLogout(Model model, SessionStatus ss) {

    if (ss != null) {
      ss.setComplete();
    }

    return "redirect:login";
  }

  public ApplicationContext getAppContext() {
    return appContext;
  }

  public void setAppContext(ApplicationContext appContext) {
    this.appContext = appContext;
  }

  public UserDAO getUserDAO() {
    return userDAO;
  }

  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public PasswordHash getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(PasswordHash passwordHash) {
    this.passwordHash = passwordHash;
  }
}
