package com.fdmgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.auth.PasswordHash;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.User;

@Controller
@SessionAttributes(names = { "user" }, types = { User.class })
public class UserController {

  @Autowired
  @Qualifier("userDAO")
  UserDAO userDAO;

  @Autowired
  @Qualifier("password")
  PasswordHash passwordHash;

  @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
  public String showDashboard(Model model, @ModelAttribute User user) {
    if (user.getRole().getName().equals("applicant")) {
      return "forward:applicantDashboard";
    } else if (user.getRole().getName().equals("recruiter")) {
      return "forward:recruiterView";
    } else if (user.getRole().getName().equals("admin")) {
      return "forward:adminDashboard";
    } else if (user.getRole().getName().equals("staff")) {
      return "forward:staffDashboard";
    } else if (user.getRole().getName().equals("manager")) {
      return "forward:managerDashboard";
    }
    return "redirect:logout";
  }

  @RequestMapping(value = "/editCurrentUser")
  public String showCurrentUserForm(Model model, @ModelAttribute User user) {

    model.addAttribute("editUser", user);
    return "edit_user_form";
  }

  @RequestMapping(value = "/editCurrentUser", method = RequestMethod.POST)
  public String editCurrentUser(Model model, @ModelAttribute User user, User editUser, @RequestParam String passworda) {

    if (passworda != null && !passworda.isEmpty() && !user.getPassword().equals(passworda)) {
      editUser.setPassword(passwordHash.hash(passworda));
    }

    userDAO.update(editUser);
    model.addAttribute("successMessage", "User Info updated");
    return "redirect:dashboard";
  }

}
