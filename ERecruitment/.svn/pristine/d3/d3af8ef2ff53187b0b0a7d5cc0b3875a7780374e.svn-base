package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.Job;
import com.fdmgroup.model.JobApplication;
import com.fdmgroup.model.User;

public class JobDAO implements IStorage<Job>{

	@Autowired
	private DBConnection dbConnection;

	public DBConnection getDbConnection() {
		return dbConnection;
	}


	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public JobDAO(){
		super();

	}

	@Override
	public Job read(long id) {
		EntityManager em = dbConnection.getEntityManager();
		Job job = em.find(Job.class, id);
		return job;
	}

	@Override
	public Job create(Job job) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(job);
		em.getTransaction().commit();
		return job;
	}

	@Override
	public Job update(Job job) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.merge(job);
		em.getTransaction().commit();
		return job;
	}

	@Override
	public boolean delete(Job job) {
		EntityManager em = dbConnection.getEntityManager();
		if(em.contains(job)){
			em.getTransaction().begin();
			em.merge(job);
			em.getTransaction().commit();
			return true;
		}
	return false;
	}
	
	public List<Job> findAll() {
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("job.findAll");
		List<Job> jobs = query.getResultList();
		return jobs;
	}
	
	public List<Job> findByPoster(User user) {
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("job.findByPoster");
		query.setParameter("posterId", user.getId());
		List<Job> jobs = query.getResultList();
		return jobs;
	}
	
}
