package com.fdmgroup.tradingplatform.dao;

import java.sql.SQLException;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Role;
import com.fdmgroup.tradingplatform.bin.SecurityRole;
import com.fdmgroup.tradingplatform.jdbc.PersonJDBC;

public class PersonRAMDAO implements IStoreable<Person> {

	private Set<Person> personSet;	
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Person t) {

		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Person read(int id) {

		em = emf.createEntityManager();
		Person person = em.find(Person.class, id);
		em.close();
		return person;
	}

	@Override
	public void update(Person t) {

		em = emf.createEntityManager();
		Person person = em.find(Person.class, t.getPersonId());
		em.getTransaction().begin();
		em.remove(person);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Person t) {

		em = emf.createEntityManager();
		Person person = em.find(Person.class, t.getPersonId());
		em.getTransaction().begin();
		em.remove(person);
		em.getTransaction().commit();	
		em.close();
	}

}
