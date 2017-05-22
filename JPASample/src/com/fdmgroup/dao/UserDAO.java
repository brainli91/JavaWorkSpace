package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.Query;

import com.fdmgroup.model.User;

public class UserDAO {

	DBConnection dbConnection = null;
	
	public UserDAO(){
		 dbConnection = DBConnection.getInstance();
		
	}
	
	public List<User> findAll(){
		Query query = dbConnection.getEntityManger().createNamedQuery("user.findAll");
		List<User> users= query.getResultList();
		return users;
	}
	public User findByUsername(String username){
		Query query = dbConnection.getEntityManger().createNamedQuery("user.findByUsername");
		query.setParameter("uname", username);
		List<User> userList = query.getResultList();
		if(userList!=null&& userList.size()!=0){
			return userList.get(0);
		}
		return null;
	}
}
