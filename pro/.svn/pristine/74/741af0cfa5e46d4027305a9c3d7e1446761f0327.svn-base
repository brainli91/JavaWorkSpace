package com.fdmgroup.tradingplatform.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;

public class RequestRAMDAO implements IStoreable<Request> {

	private Set<Request> requestSet = new HashSet<Request>();
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Request t) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Request read(int id) {
		
		em = emf.createEntityManager();
		Request request = em.find(Request.class, id);
		em.close();
		return request;
	}

	@Override
	public void update(Request t) {
		
		em = emf.createEntityManager();
		Request request = em.find(Request.class, t.getRequestId());
		em.getTransaction().begin();
		em.remove(request);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Request t) {
		
		em = emf.createEntityManager();
		Request request = em.find(Request.class, t.getRequestId());
		em.getTransaction().begin();
		em.remove(request);
		em.getTransaction().commit();	
		em.close();
	}

	public Set<Request> read(Person person){
		
		requestSet = new HashSet<Request>();
		em = emf.createEntityManager();
		List<Request> results = em.createQuery("SELECT o FROM Request o WHERE o.person.personId =:Id")
				.setParameter("Id", person.getPersonId()).getResultList();
		for(Request request : results){
			requestSet.add(request);
		}
		return requestSet;
	}
	
}
