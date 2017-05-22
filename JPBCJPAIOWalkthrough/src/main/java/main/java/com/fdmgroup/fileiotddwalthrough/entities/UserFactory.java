package com.fdmgroup.fileiotddwalthrough.entities;

public class UserFactory {

	public User createUser(String username, String password, String role) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		return user;
	}
}
