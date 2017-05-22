package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;

import com.fdmgroup.tradingplatform.bin.CurrentStockStats;
import com.fdmgroup.tradingplatform.jdbc.CurrentStockStatsJDBC;

public class CurrentStockStatsRAMDAO {

	private CurrentStockStats currentStockStats;
	
	public CurrentStockStats read(int id) {
		
		CurrentStockStatsJDBC CurrentStockStatsJDBC = new CurrentStockStatsJDBC();
				
		try {
			currentStockStats = CurrentStockStatsJDBC.readRecords(id);
			return currentStockStats;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


}
