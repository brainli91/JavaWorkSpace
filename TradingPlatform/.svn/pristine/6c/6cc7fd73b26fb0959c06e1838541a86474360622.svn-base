package com.fdmgroup.tradingplatform.controller;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fdmgroup.tradingplatform.dao.CollectionCompanyDAO;
import com.fdmgroup.tradingplatform.dao.CollectionRequestDAO;
import com.fdmgroup.tradingplatform.dao.CollectionRoleDAO;
import com.fdmgroup.tradingplatform.dao.CollectionTradeDAO;
import com.fdmgroup.tradingplatform.dao.CollectionUserDAO;
import com.fdmgroup.tradingplatform.databasedao.RoleDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

public class AdminController {
	private UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();

	private RoleDAO_JDBC roleDAO = RoleDAO_JDBC.getInstance();

	public void printUserList() {
		List<User> users = userDAO.readAll();
		if (users == null || users.size() == 0) {
			System.out
					.println("An error occurred while searching for users. Please try again.");
		}
		for (User user : users) {
			System.out.println("Id: " + user.getId() + " Username: "
					+ user.getUserName() + " Name:" + user.getFirstName() + " "
					+ user.getLastName() + " Password: " + user.getPassWord()
					+ " Portfolio: " + user.getPortfolio() + " Roles: "
					+ user.getRoles());
		}
	}

	public User adminAddUser(String uname, String fname, String lname,
			String pw, List<String> roleNames) {

		User existingUser = userDAO.findByUserName(uname);
		if (existingUser != null) {
			System.out.println("Username is already taken");
		} else {
			List<Role> listRole = new ArrayList<Role>();
			for (String name : roleNames) {
				Role foundRole = roleDAO.findRoleByRoleName(name);
				listRole.add(foundRole);
			}

			User newCreatedUser = new User(uname, fname, lname, pw, listRole);

			userDAO.create(newCreatedUser);
			System.out.println("Successfully Add new user!");
			return newCreatedUser;
		}
		return null;
	}

	public boolean adminDeleteUser(String uname) {
		User targetUser = userDAO.findByUserName(uname);
		if (targetUser != null) {
			userDAO.delete(targetUser);
			System.out.println("User " + targetUser.getUserName() + ", "
					+ targetUser.getFirstName() + " "
					+ targetUser.getLastName() + " has deleted");
		}

		else {
			System.out.println("Fail to delete");
			return false;
		}
		return true;
	}

	public boolean adminResetPassword(String uname, String pw) {
		User targetUser = userDAO.findByUserName(uname);
		targetUser.setPassWord(pw);
		targetUser = userDAO.update(targetUser);
		if (targetUser == null) {
			System.out
					.println("An error occurred while processing your request. Please try again");
			return false;
		} else {
			System.out.println("Password of user " + targetUser.getUserName()
					+ " has been reset to: " + targetUser.getPassWord());
			return true;
		}
	}

	public boolean adminEditUser(String uname, String fname, String lname,
			List<String> roles) {

		User persistentUser = userDAO.findByUserName(uname);

		if (persistentUser == null) {
			System.out.println("User could not be found. Please try again");
		} else {
			persistentUser.setFirstName(fname);
			persistentUser.setLastName(lname);

			List<Role> listRoles = new ArrayList<Role>();

			for (String name : roles) {
				Role foundRole = roleDAO.findRoleByRoleName(name);

				if (foundRole != null) {
					listRoles.add(foundRole);
				}
			}

			persistentUser.setRoles(listRoles);

			persistentUser = userDAO.update(persistentUser);
			// persistentUser = userRoleDAO.delete(persistentUser);
			// persistentUser = userRoleDAO.create(persistentUser, roles);
		}
		if (persistentUser == null) {
			System.out
					.println("Error occurred while processing your request.Please try again.");
		} else {
			System.out.println("Successfully updated user "
					+ persistentUser.getUserName());
			return true;
		}
		return false;
	}

	public void adminReadLog(String fileDir) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileDir);
			br = new BufferedReader(fr);

			String line = "";
			System.out.println("************************ USER LOG ************************");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeStream(fr);
			closeStream(br);
		}

	}

	public static void closeStream(Closeable closeable) {
		if (closeable != null) {
			try {
				closeable.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}