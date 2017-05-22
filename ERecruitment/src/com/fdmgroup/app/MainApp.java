package com.fdmgroup.app;

import com.fdmgroup.auth.PasswordHash;
import com.fdmgroup.dao.ApplicantProfileDAO;
import com.fdmgroup.dao.DBConnection;
import com.fdmgroup.dao.RoleDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.ApplicantProfile;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

public class MainApp {
  
	static DBConnection db;
	
  public static void main(String[] args) {
	  db = new DBConnection();
	  RoleDAO roleDAO = new RoleDAO();
	  roleDAO.setDbConnection(db);
	  Role applicant = new Role(1, "applicant");
	  roleDAO.create(applicant);
	  Role recruiter = new Role(2, "recruiter");
	  roleDAO.create(recruiter);
	  Role admin = new Role(3, "admin");
	  roleDAO.create(admin);
	  Role manager = new Role(4, "manager");
	  roleDAO.create(manager);
	  System.out.println("applicant");
	  User applicantUser = new User();
	  applicantUser.setActive(1);
	  applicantUser.setRole(applicant);
	  applicantUser.setBlocked(0);
	  applicantUser.setPassword(new PasswordHash().hash("password"));
	  applicantUser.setEmail("jdoe@gmail.com");
	  applicantUser.setFirstName("John");
	  applicantUser.setLastName("Doe");
	  
	  ApplicantProfileDAO profileDAO = new ApplicantProfileDAO();
	  profileDAO.setDbConnection(db);
	  ApplicantProfile profile = new ApplicantProfile();
	  profile.setUser(applicantUser);
	  applicantUser.setApplicantProfile(profile);
	  profileDAO.create(profile);
	  
	  System.out.println("admin");
	  User adminUser = new User();
	  adminUser.setActive(1);
	  adminUser.setRole(admin);
	  adminUser.setBlocked(0);
	  adminUser.setPassword(new PasswordHash().hash("admin"));
	  adminUser.setEmail("admin@admin.com");
	  adminUser.setFirstName("Admin");
	  adminUser.setLastName("Admin");
	  
	  UserDAO userDAO = new UserDAO();
	  userDAO.setDbConnection(db);
	  userDAO.create(adminUser);
	  
	  System.out.println("recruiter");
	  User recruiterUser = new User();
	  recruiterUser.setActive(1);
	  recruiterUser.setRole(recruiter);
	  recruiterUser.setBlocked(0);
	  recruiterUser.setPassword(new PasswordHash().hash("recruiter"));
	  recruiterUser.setEmail("recruiter@fdm.com");
	  recruiterUser.setFirstName("Franz");
	  recruiterUser.setLastName("Recruiter");
	  userDAO.create(recruiterUser);
	  
	  System.out.println("manager");
	  User managerUser = new User();
	  managerUser.setActive(1);
	  managerUser.setRole(manager);
	  managerUser.setBlocked(0);
	  managerUser.setPassword(new PasswordHash().hash("manager"));
	  managerUser.setEmail("boss@fdm.com");
	  managerUser.setFirstName("Boss");
	  managerUser.setLastName("Manager");
	  userDAO.create(managerUser);
	  
	  System.exit(0);
  }
}
