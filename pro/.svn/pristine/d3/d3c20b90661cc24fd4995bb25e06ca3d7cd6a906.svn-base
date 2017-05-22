package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.jdbc.PersonJDBC;

public class LogRAMDAO {

	private EntityManagerFactory emf;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	private EntityManager em;
	
	public Person read(String userName) {
		
		em = emf.createEntityManager();
		List<Person> results = em.createQuery("SELECT p FROM Person p WHERE p.userName =:Name")
				.setParameter("Name", userName).getResultList();
		if(results.size() == 0){
			return null;
		}
		else {
			return results.get(0);
		}
	}

}
