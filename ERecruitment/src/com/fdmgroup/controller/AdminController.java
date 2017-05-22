package com.fdmgroup.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.auth.PasswordHash;
import com.fdmgroup.dao.ApplicantProfileDAO;
import com.fdmgroup.dao.RoleDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.ApplicantProfile;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

@Controller
public class AdminController {

  @Autowired
  @Qualifier("userDAO")
  UserDAO userDAO;

  @Autowired
  @Qualifier("roleDAO")
  RoleDAO roleDAO;

  @Autowired
  @Qualifier("applicantProfileDAO")
  ApplicantProfileDAO applicantProfileDAO;

  @Autowired
  @Qualifier("password")
  PasswordHash passwordHash;

  @RequestMapping(value = "/adminDashboard", method = { RequestMethod.GET, RequestMethod.POST })
  public String viewAdminDashboard(Model model, User user) {
    BufferedReader br = null;

    try {
      List<String> allSysLogs = new ArrayList<>();
      br = new BufferedReader(new FileReader(new File("C:/apache-tomcat-8.0.26/logs/system.log")));
      while (br.readLine() != null) {
        allSysLogs.add(br.readLine());
      }
      br.close();
      Collections.reverse(allSysLogs);
      List<String> syslog = allSysLogs.stream().limit(5).collect(Collectors.toList());
      model.addAttribute("syslog", syslog);

      List<String> allUserLogs = new ArrayList<>();
      br = new BufferedReader(new FileReader(new File("C:/apache-tomcat-8.0.26/logs/user.log")));
      while (br.readLine() != null) {
        allUserLogs.add(br.readLine());
      }
      br.close();
      Collections.reverse(allUserLogs);
      List<String> userlog = allUserLogs.stream().limit(5).collect(Collectors.toList());
      model.addAttribute("userlog", userlog);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "admin_dashboard";
  }

  @RequestMapping(value = "/viewUsers", method = { RequestMethod.GET, RequestMethod.POST })
  public String viewAllUsers(Model model, User user) {
    List<User> users = userDAO.findAll();
    System.out.println("showing all the users:" + users);
    model.addAttribute("users", users);
    return "view_users";
  }

  @RequestMapping(value = "/viewBlockedUsers", method = RequestMethod.GET)
  public String viewBlockedUsers(Model model, User user) {
    List<User> blockedUsers = userDAO.findBlocked();
    System.out.println("showing all the blocked users:" + blockedUsers);
    model.addAttribute("blockedUsers", blockedUsers);
    return "view_blockedUser";
  }

  @RequestMapping(value = "/viewActiveUsers", method = RequestMethod.GET)
  public String viewActiveUsers(Model model, User user) {
    List<User> activeUsers = userDAO.findActive();
    System.out.println("showing all the active users:" + activeUsers);
    model.addAttribute("activeUsers", activeUsers);
    return "view_activeUser";
  }

  @RequestMapping(value = "/createUser", method = RequestMethod.GET)
  public String showCreateUserForm(Model model) {
    User newUser = new User();
    model.addAttribute("newUser", newUser);
    return "create_user";
  }

  @RequestMapping(value = "/createUser", method = RequestMethod.POST)
  public String createUser(Model model, User newUser, @RequestParam String roleName, @RequestParam String passwordAgain,
      @RequestParam String password) {

    if (userDAO.findByEmail(newUser.getEmail()) != null) {
      model.addAttribute("errorMsg", "Email already exist.");
      model.addAttribute("newUser", newUser);
      return "create_user";
    }

    if (passwordAgain.length() < 8 || password.length() < 8) {
      model.addAttribute("errorMsg", "Invalid password length");
      model.addAttribute("newUser", newUser);
      return "create_user";
    }

    if (!password.equals(passwordAgain)) {
      model.addAttribute("errorMsg", "Password does not match");
      model.addAttribute("newUser", newUser);
      return "create_user";
    }

    Role applicantRole = roleDAO.findByName(roleName);
    if (applicantRole == null) {
      model.addAttribute("errorMsg", "Selected role does not exist.");
      model.addAttribute("newUser", newUser);
      return "create_user";
    } else {
      newUser.setRole(applicantRole);
    }

    String hashedPassword = passwordHash.hash(newUser.getPassword());
    newUser.setPassword(hashedPassword);
    newUser.setActive(1);
    newUser.setBlocked(0);

    if (applicantRole.getName().equals("applicant")) {
      ApplicantProfile ap = new ApplicantProfile();
      ap.setUser(newUser);
      newUser.setApplicantProfile(ap);
      applicantProfileDAO.create(ap);
    } else {
      userDAO.create(newUser);
    }

    String successMsg = newUser.getEmail() + " created!";
    model.addAttribute("successMsg", successMsg);

    return "forward:/viewUsers";
  }

  @RequestMapping(value = "/removeUser", method = RequestMethod.GET)
  public String removeUser(Model model, @RequestParam long id) {
    User removeUser = userDAO.read(id);
    userDAO.delete(removeUser);
    String successMsg = removeUser.getEmail() + " deactivated";
    model.addAttribute("successMsg", successMsg);
    return "forward:/viewUsers";
  }

  @RequestMapping(value = "/reactivateUser", method = RequestMethod.GET)
  public String unremoveUser(Model model, @RequestParam long id) {
    User unremoveUser = userDAO.read(id);
    unremoveUser.setActive(1);
    String successMsg = unremoveUser.getEmail() + " reactivated";
    model.addAttribute("successMsg", successMsg);
    return "forward:/viewUsers";
  }

  @RequestMapping(value = "/editUser", method = RequestMethod.GET)
  public String editUser(Model model, @ModelAttribute User user, @RequestParam long id) {
    User editUser = userDAO.read(id);
    System.out.println(editUser);
    // editUser.setPassword("");
    model.addAttribute("editUser", editUser);
    return "edit_user";
  }

  @RequestMapping(value = "/editUser", method = RequestMethod.POST)
  public String processEditUser(Model model, @ModelAttribute User editUser, @RequestParam String roleName) {

    Role role = roleDAO.findByName(roleName);
    if (role == null) {
      model.addAttribute("errorMsg", "Selected role does not exist.");
      model.addAttribute("editUser", editUser);
      return "create_user";
    } else {
      editUser.setRole(role);
    }
    User dbUser = userDAO.read(editUser.getId());
    dbUser.setFirstName(editUser.getFirstName());
    dbUser.setLastName(editUser.getLastName());
    dbUser.setRole(editUser.getRole());

    userDAO.update(dbUser);
    System.out.println("<-------EDIT PASSWORD-------->");
    System.out.println(dbUser);
    String successMsg = editUser.getEmail() + " edited";
    model.addAttribute("successMsg", successMsg);
    return "forward:/viewUsers";

  }

  @RequestMapping(value = "/blockUser", method = RequestMethod.GET)
  public String blockUser(Model model, @RequestParam long id) {
    User blockUser = userDAO.read(id);
    blockUser.setBlocked(1);
    userDAO.update(blockUser);
    String successMsg = blockUser.getEmail() + " blocked";
    model.addAttribute("successMsg", successMsg);
    return "forward:/viewUsers";
  }

  @RequestMapping(value = "/unblockUser", method = RequestMethod.GET)
  public String unblockUser(Model model, @RequestParam long id) {
    User unblockUser = userDAO.read(id);
    unblockUser.setBlocked(0);
    userDAO.update(unblockUser);
    String successMsg = unblockUser.getEmail() + " unblocked";
    model.addAttribute("successMsg", successMsg);
    return "forward:/viewUsers";
  }

  @RequestMapping(value = "/systemLog", method = RequestMethod.GET)
  public String showSystemLog(Model model) {
    BufferedReader br = null;

    try {
      List<String> lines = new ArrayList<>();
      br = new BufferedReader(new FileReader(new File("C:/apache-tomcat-8.0.26/logs/system.log")));
      while (br.readLine() != null) {

        lines.add(br.readLine());
      }

      br.close();
      Collections.reverse(lines);

      model.addAttribute("syslog", lines);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "system_log";
  }

  @RequestMapping(value = "/userLog", method = RequestMethod.GET)
  public String showUserLog(Model model) {
    BufferedReader br = null;

    try {
      List<String> lines = new ArrayList<>();
      br = new BufferedReader(new FileReader(new File("C:/apache-tomcat-8.0.26/logs/user.log")));
      while (br.readLine() != null) {

        lines.add(br.readLine());
      }

      br.close();
      Collections.reverse(lines);

      model.addAttribute("userlog", lines);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "user_log";
  }

  public UserDAO getUserDAO() {
    return userDAO;
  }

  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public RoleDAO getRoleDAO() {
    return roleDAO;
  }

  public void setRoleDAO(RoleDAO roleDAO) {
    this.roleDAO = roleDAO;
  }

  public ApplicantProfileDAO getApplicantProfileDAO() {
    return applicantProfileDAO;
  }

  public void setApplicantProfileDAO(ApplicantProfileDAO applicantProfileDAO) {
    this.applicantProfileDAO = applicantProfileDAO;
  }

  public PasswordHash getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(PasswordHash passwordHash) {
    this.passwordHash = passwordHash;
  }

}
