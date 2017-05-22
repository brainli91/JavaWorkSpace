package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {
	
	private static DBConnection dbConnection =null;
	private EntityManagerFactory emf = null;
	private EntityManager em = null;
	

	private DBConnection(){
		super();
	}
	
	private void init(){
		if(emf== null)
			emf=Persistence.createEntityManagerFactory("JSPDemo");
	
		em = emf.createEntityManager();
	}
	public static DBConnection getInstance(){
		if (dbConnection ==null){
			dbConnection = new DBConnection ();
		}
		return dbConnection;
	}
	
	public EntityManager getEntityManager(){
		if(em==null|| em.isOpen())
			init();
		return em;
		
	}
	public void close(){
		if(em==null|| em.isOpen())
			em.close();
		
	}
}
