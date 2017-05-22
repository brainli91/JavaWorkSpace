package com.fdmgroup.tradingplatform.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import com.fdmgroup.tradingplatform.bin.CurrentShareholderShares;

public class CurrentShareholderSharesJDBC {

	private Connection connection = null;
	private Properties properties = null;
	private PreparedStatement stmt = null;
	
	public Set<CurrentShareholderShares> readRecords(int id) throws SQLException, ClassNotFoundException {
		String query;
		CurrentShareholderShares currentShareholderShare;
		Set<CurrentShareholderShares> currentShareholderShares = new HashSet<CurrentShareholderShares>();
		
		connection = DBConnector.getConnection();
	
		CallableStatement cs = connection.prepareCall("{call CREATE_SHAREHOLDER_SHARES_VIEW}");
		cs.executeUpdate();
	

		stmt = connection.prepareStatement("SELECT * FROM current_shareholder_shares WHERE shareholder_id = ?");
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
			currentShareholderShare = new CurrentShareholderShares(rs.getInt(1), rs.getInt(2), rs.getInt(3));
			currentShareholderShares.add(currentShareholderShare);
		}
		return currentShareholderShares;
	}
	
	
}




