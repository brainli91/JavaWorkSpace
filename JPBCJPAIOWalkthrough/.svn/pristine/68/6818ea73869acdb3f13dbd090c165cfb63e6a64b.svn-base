package com.fdmgroup.fileiotddwalthrough.view;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.fileiotddwalthrough.controller.RegistrationController;
import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;
import com.fdmgroup.fileiotddwalthrough.io.ReadCommand;
import com.fdmgroup.fileiotddwalthrough.io.WriteCommand;
import com.fdmgroup.fileiotddwalthrough.jpa.UserORMReadCommand;
import com.fdmgroup.fileiotddwalthrough.jpa.UserORMWriteCommand;

public class ORMRunner {
	public static void main(String[] args) {
		UserFactory userFactory = new UserFactory();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceunit");
		WriteCommand writeCommand = new UserORMWriteCommand(entityManagerFactory);
		ReadCommand readCommand = new UserORMReadCommand(entityManagerFactory, userFactory);
		RegistrationController controller = new RegistrationController(userFactory, writeCommand, readCommand);
		
		//controller.registerUser("JPA", "123", "ABC");
		controller.registerUser("Duc", "123", "ABC");
		controller.registerUser("B", "123", "ABC");
		controller.registerUser("D", "123", "ABC");
		controller.registerUser("Das", "123", "ABC");
		
		List<User> users = controller.getAllUser();
		for (User user : users) {
			System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getRole());
		}
	}
}
