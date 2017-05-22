package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.fdmgroup.model.User;

public class UserDAO {

	private static UserDAO userDAO =null;
	
	private UserDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static UserDAO getInstance(){
		
		if(userDAO==null)
			userDAO =new UserDAO();
		return userDAO;
		
	}
	
	public List<User> finaAll(){
		
		EntityManager em = DBConnection.getInstance().getEntityManager();
		Query query = em.createNamedQuery("user.findAll");
		List<User> users = query.getResultList();
		return users;
		
	}
	
	public User findUserByUsername(String username){
		
		EntityManager em = DBConnection.getInstance().getEntityManager();
		Query query = em.createNamedQuery("user.findByUsername");
		query.setParameter("uname", username);
		List<User> users = query.getResultList();
		
		if(users ==null || users.size() !=1)
			return null;
		
		return  users.get(0);
		
	}
}
