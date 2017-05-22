package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.entity.User;

public class UserDAO implements IStorage<User> {
	
	@Autowired
	private DBConnection dbConnection;
	

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	
	
	public UserDAO() {
		super();
	}



	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public User read(long id) {
		EntityManager em = dbConnection.getEntityManager();
		return em.find(User.class, id);
	}

	@Override
	public User create(User user) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}

	@Override
	public User update(User user) {
		EntityManager em =  dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		
		return user;
	}

	@Override
	public boolean delete(User user) {
		EntityManager em = dbConnection.getEntityManager();
		if(em.contains(user)) {
			em.getTransaction().begin();
			user.setActive(0);
			em.merge(user);
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
	
	public List<User> findAll(){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("user.findAll");
		List<User> users = query.getResultList();
		
		return users;
		
	}
	
	public User findByEmail(String email){
		
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("user.findByEmail");
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		if (users == null && users.size()!=1){
			return null;
		}
		return users.get(0);
	}
	
	public List<User> findByFirstName (String firstName){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("user.findByFirstName");
		query.setParameter("firstName", firstName);
		List<User> users = query.getResultList();
		return users;
	}
	
	public List<User> findByLastName (String lastName){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("findByLastName");
		List<User> users = query.getResultList();
		return users;
	}
	
	public List<User> findByActive(){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("findByActive");
		List<User> users = query.getResultList();
		return users;
	}
	
	public List<User> findCurrentBirthday(){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("user.findCurrentBirthday");
		List<User> users = query.getResultList();
		return users;
	}

}
