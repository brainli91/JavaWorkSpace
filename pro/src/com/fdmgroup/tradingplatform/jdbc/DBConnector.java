package com.fdmgroup.tradingplatform.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

	private static Connection connection = null;

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		if (connection != null)
			return connection;
		else {
			Properties properties = new Properties();
//				FileInputStream input = new FileInputStream(
//						"dbproperties");
//				properties.load(input);
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "trainee1";
			String password = "!QAZSE4";

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			connection = DriverManager.getConnection(url, user, password);



			return connection;
		}

	}
}
