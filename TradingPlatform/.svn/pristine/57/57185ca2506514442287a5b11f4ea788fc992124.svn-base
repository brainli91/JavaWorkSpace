package com.fdmgroup.tradingplatform.dao;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.Trade;
import com.fdmgroup.tradingplatform.model.User;

public class CollectionRoleDAO implements IRoleDAO {

	private List<Role> roles = new ArrayList<Role>();

	private List<User> users = new ArrayList<User>();

	private static CollectionRoleDAO roleDAO = null;

	private CollectionRoleDAO() {

		roles.add(new Role(1, "Admin"));
		roles.add(new Role(2, "Broker"));
		roles.add(new Role(3, "Shareholder"));
	}

	public static CollectionRoleDAO getInstance() {
		if (roleDAO == null) {
			roleDAO = new CollectionRoleDAO();
		}
		return roleDAO;
	}

	public List<Role> readAll() {
		return roles;
	}

	public Role create(Role t) {
		t.setId(generateId());
		roles.add(t);
		return t;
	}

	private Integer generateId() {
		return roles.size() + 1;
	}

	public Role read(int id) {
		for (Role role : roles) {
			if (role.getId() == id) {
				return role;
			}
		}
		return null;
	}

	public Role update(Role t) {
		if (roles.contains(t)) {
			int i = roles.indexOf(t);
			roles.set(i, t);

			return t;
		}

		return null;
	}

	public boolean delete(Role t) {
		return roles.remove(t);
	}

	public List<Role> findRoleByUser(User user) {
		List<Role> tempRoleList = new ArrayList<Role>();
		for (User eachUser : users) {
			if (eachUser.equals(user)) {
				tempRoleList.addAll(eachUser.getRoles());
			}

		}
		return tempRoleList;
	}

	public List <Role> findRoleByUserName(String name) {
		for (User user : users) {
			if (user.getUserName().equals(name)) {
				return user.getRoles();
			}
		}
		return null;
		
	}
	
	public Role findRoleByRoleName(String name) {
		for (Role role : roles) {
			if (role.getName().equals(name)) {
				return role;
			}
		}
		return null;
	}
	

}
