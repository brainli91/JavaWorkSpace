package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnectionImpl implements DBConnection{
	
	EntityManagerFactory emf = null;
	EntityManager em = null;
	
	private void init(){
		if(em==null){
			emf =Persistence.createEntityManagerFactory("SpringMVCExample");
		em = emf.createEntityManager();
		}
	}
	
	@Override
	public EntityManager getEntityManager() {
		if(em== null|| em.isOpen())
			init();
		return em;
	}
	
	
	

}
