package com.fdmgroup.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.JobApplication;

public class JobApplicationDAO implements IStorage<JobApplication> {

	@Autowired
	DBConnection dbConnection;
	
	public JobApplicationDAO() {
		super();
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public JobApplication read(long id) {
		EntityManager em = dbConnection.getEntityManager();
		return em.find(JobApplication.class, id);
	}

	@Override
	public JobApplication create(JobApplication t) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		return t;
	}

	@Override
	public JobApplication update(JobApplication t) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		
		return t;
	}

	@Override
	public boolean delete(JobApplication t) {
		EntityManager em = dbConnection.getEntityManager();
		if(em.contains(t)) {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			return true;
		}
		
		return false;
	}

}
