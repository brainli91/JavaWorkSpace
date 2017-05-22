package com.fdmgroup.fileiotddwalthrough.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;
import com.fdmgroup.fileiotddwalthrough.io.ReadCommand;

public class DBReadCommand implements ReadCommand {
	private ConnectionFactory connectionFactory;
	private UserFactory userFactory;

	// Set up out Driver
	public DBReadCommand(ConnectionFactory connectionFactory, UserFactory userFactory) {
		this.connectionFactory = connectionFactory;
		this.userFactory = userFactory;
	}

	@Override
	public List<User> read() {
		List<User> allUsers = new ArrayList<User>();
		Connection connection = connectionFactory.getConnection();
		String query = "SELECT * FROM users";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String role = resultSet.getString("role");
				allUsers.add(userFactory.createUser(username, password, role));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}
}
