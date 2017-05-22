package com.fdmgroup.tradingplatform.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.Share;
import com.fdmgroup.tradingplatform.model.User;

public class CollectionUserDAO implements IUserDAO {

	private List<User> users = new ArrayList<User>();

	private static CollectionUserDAO userDAO = null;

	private List<Share> shares = new ArrayList<Share>();

	private CollectionUserDAO() {
//		Connection con = null;
//		CallableStatement cs = null;
//		ResultSet rs = null;
//		
//		String query = "{call findUser"
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role(1, "Admin"));
		users.add(new User(1, "brian", "Brian", "Li", "123456", roles));
	}

	public static CollectionUserDAO getInstance() {
		if (userDAO == null)
			userDAO = new CollectionUserDAO();

		return userDAO;
	}

	public List<User> readAll() {
		return users;
	}

	public User create(User t) {

		t.setId(generateId());
		users.add(t);
		return t;
	}

	private Integer generateId() {
		return users.size() + 1;
	}

	public User read(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	
	public User update(User t) {
		if (users.contains(t)) {
			int i = users.indexOf(t);
			users.set(i, t);

			return t;
		}

		return null;
	}


	public boolean delete(User t) {
		return users.remove(t);
	}

	public boolean deleteById(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return users.remove(user);
		}
		return false;

	}

	public User findByUserName(String userName) {
		for (User user : users) {
			if (user.getUserName().equals(userName))
				return user;
		}

		return null;
	}

}
