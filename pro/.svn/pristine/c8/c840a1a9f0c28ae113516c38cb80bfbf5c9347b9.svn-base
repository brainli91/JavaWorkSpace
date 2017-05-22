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
import com.fdmgroup.tradingplatform.bin.CurrentStockStats;
import com.fdmgroup.tradingplatform.dao.IStoreable;

public class CurrentStockStatsJDBC {

	private Connection connection = null;
	private Properties properties = null;
	private PreparedStatement stmt = null;
	
	public CurrentStockStats readRecords(int id) throws SQLException {

		String query;
		CurrentStockStats currentStockStats = null;
		
		try {
			connection = DBConnector.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
			
		}
		properties = SQLProperties
				.getProperties("dml.properties");
			
		CallableStatement cs = connection.prepareCall("{call CREATE_STOCK_STATS_VIEW}");
		cs.executeUpdate();	
		
		query = properties.getProperty("GetStock");

		stmt = connection.prepareStatement(query);
		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			
			currentStockStats = new CurrentStockStats(rs.getInt(1), rs.getInt(2), rs.getInt(3));
		}
		
		return currentStockStats;
	}
	
	
}
