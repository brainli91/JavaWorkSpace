package com.fdmgroup.tradingplatform.jdbc;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Role;

public class PersonJDBC {
	
	private Connection connection = null;
	private Properties properties = null;
	private PreparedStatement stmt = null;
	
	public int readRecordId(String userName) throws SQLException {

		String query;
		Person person;
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return (Integer) null;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		query = properties.getProperty("RetrievePersonByUsername");

		stmt = connection.prepareStatement(query);
		stmt.setString(1, userName);
		
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
			return rs.getInt(1);
		}
		return -1;
	}
	
}

