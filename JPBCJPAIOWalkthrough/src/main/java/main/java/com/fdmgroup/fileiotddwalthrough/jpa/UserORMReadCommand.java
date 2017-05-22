package com.fdmgroup.fileiotddwalthrough.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;
import com.fdmgroup.fileiotddwalthrough.io.ReadCommand;

public class UserORMReadCommand implements ReadCommand {
	EntityManagerFactory entityManagerFactory;

	// Dependency Injection to provide our EntityManagerFactory
	public UserORMReadCommand(EntityManagerFactory entityManagerFactory, UserFactory userFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<User> read() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String sql = "SELECT * FROM users";
		Query query = entityManager.createNativeQuery(sql, User.class);
		
		List<User> allUsers = query.getResultList();
		entityManager.close();
		return allUsers;
	}
}
