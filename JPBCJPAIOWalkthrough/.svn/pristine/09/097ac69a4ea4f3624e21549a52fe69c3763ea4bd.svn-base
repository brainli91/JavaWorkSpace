package com.fdmgroup.fileiotddwalthrough.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.io.WriteCommand;

public class DBWriteCommand implements WriteCommand {
	private ConnectionFactory connectionFactory;

	// Set up out Driver
	public DBWriteCommand(ConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
	}

	@Override
	public void write(User user) {
		Connection connection = connectionFactory.getConnection();
		String query = "INSERT INTO users(username, password, role) VALUES (?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
