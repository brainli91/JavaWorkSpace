package com.fdmgroup.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.entity.User;

public class UserDAO {

	@Autowired
	private DBConnection dbConnection;

	public UserDAO() {
		super();
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public User findByUsername(String username){
		EntityManager em = dbConnection.getEntityManager();
		Query query= em.createNamedQuery("user.findByUsername");
		query.setParameter("uname", username);
		
		List<User> users = query.getResultList();
		
		if(users != null && users.size()==1)
			return users.get(0);
		
		return null;
	}
	
	
}
