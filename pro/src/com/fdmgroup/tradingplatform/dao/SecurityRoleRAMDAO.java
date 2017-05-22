package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.SecurityRole;
import com.fdmgroup.tradingplatform.jdbc.SecurityRoleJDBC;

public class SecurityRoleRAMDAO {
	
	private Set<SecurityRole> securityRoleSet;
	
	public Set<SecurityRole> read(int id) {
		
		SecurityRoleJDBC securityRoleJDBC = new SecurityRoleJDBC();
				
		try {
			securityRoleSet = securityRoleJDBC.readRecords(id);
			return securityRoleSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
