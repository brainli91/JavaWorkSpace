package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.fdmgroup.tradingplatform.bin.CurrentShareholderShares;
import com.fdmgroup.tradingplatform.bin.SecurityRole;
import com.fdmgroup.tradingplatform.jdbc.CurrentShareholderSharesJDBC;
import com.fdmgroup.tradingplatform.jdbc.SecurityRoleJDBC;

public class CurrentShareholderSharesRAMDAO  {

	private Set<CurrentShareholderShares> currentShareholderShares;
	
	public Set<CurrentShareholderShares> read(int id) throws ClassNotFoundException {
		
		CurrentShareholderSharesJDBC currentShareholderSharesJDBC = new CurrentShareholderSharesJDBC();
				
		try {
			currentShareholderShares = currentShareholderSharesJDBC.readRecords(id);
			return currentShareholderShares;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}

}
