package com.fdmgroup.tradingplatform.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.fdmgroup.tradingplatform.bin.SecurityRole;

public class SecurityRoleJDBC {

	private Connection connection = null;
	private Properties properties = null;
	private PreparedStatement stmt = null;
	
	public Set<SecurityRole> readRecords(int id) throws SQLException {

		String query;
		SecurityRole securityRole;
		Set<SecurityRole> securityRoles = new HashSet<SecurityRole>();
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
		
		CallableStatement cs = connection.prepareCall("{call CREATE_SECURITYROLE_VIEW}");
		cs.executeUpdate();		
		
		query = properties.getProperty("GetSecurityRole");

		stmt = connection.prepareStatement(query);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
			securityRole = new SecurityRole(rs.getInt(1), rs.getString(2), rs.getInt(3));
			securityRoles.add(securityRole);
		}
		return securityRoles;
	}
	
	
}
