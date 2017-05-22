package com.fdmgroup.fileiotddwalthrough.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.io.WriteCommand;

public class UserORMWriteCommand implements WriteCommand {
	EntityManagerFactory entityManagerFactory;

	// Dependency Injection to provide our EntityManagerFactory
	public UserORMWriteCommand(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public void write(User user) {
		// Create an entity manager. This KIND OF like a Connection
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Write commands require a transaction
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		// Write out broker to the database
		entityManager.persist(user);

		entityTransaction.commit();
		entityManager.close();
	}
}
