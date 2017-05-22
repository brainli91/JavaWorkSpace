package com.fdmgroup.fileiotddwalthrough.view;

import java.util.List;

import com.fdmgroup.fileiotddwalthrough.controller.RegistrationController;
import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;
import com.fdmgroup.fileiotddwalthrough.io.ReadCommand;
import com.fdmgroup.fileiotddwalthrough.io.WriteCommand;
import com.fdmgroup.fileiotddwalthrough.jdbc.ConnectionFactory;
import com.fdmgroup.fileiotddwalthrough.jdbc.DBReadCommand;
import com.fdmgroup.fileiotddwalthrough.jdbc.DBWriteCommand;

public class DBRunner {
	public static void main(String[] args) {
		UserFactory userFactory = new UserFactory();
		ConnectionFactory connectionFactory = new ConnectionFactory();
		WriteCommand writeCommand = new DBWriteCommand(connectionFactory);
		ReadCommand readCommand = new DBReadCommand(connectionFactory, userFactory);
		RegistrationController controller = new RegistrationController(userFactory, writeCommand, readCommand);

		/*
		 * controller.registerUser("Duc", "123", "ABC");
		 * controller.registerUser("B", "123", "ABC");
		 * controller.registerUser("D", "123", "ABC");
		 * controller.registerUser("Das", "123", "ABC");
		 */

		List<User> users = controller.getAllUser();
		for (User user : users) {
			System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getRole());
		}
	}
}
