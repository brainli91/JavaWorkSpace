package com.fdmgroup.fileiotddwalthrough.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public ConnectionFactory() {
		// Driver Manager- Manages our database driver
		// Singleton & ConnectionFactory
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		String user = "ducnguyen";
		String password = "password123";

		try {
			// Talk to database
			// Using the Interfaces to allow us to be Database Agnostic
			// thin -> Driver type 4 (thin because nothing between java code and
			// database
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fdmgroup.com:1521:xe", user,
					password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
