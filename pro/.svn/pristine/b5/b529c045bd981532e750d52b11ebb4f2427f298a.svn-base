package com.fdmgroup.tradingplatform.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.Trade;

public class TradeRAMDAO implements IStoreable<Trade> {

	private Set<Trade> tradeSet = new HashSet<Trade>();
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Trade t) {

		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Trade read(int id) {
		
		em = emf.createEntityManager();
		Trade trade = em.find(Trade.class, id);
		em.close();
		return trade;
	}

	@Override
	public void update(Trade t) {
		
		em = emf.createEntityManager();
		Trade trade = em.find(Trade.class, t.getTradeId());
		em.getTransaction().begin();
		em.remove(trade);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Trade t) {
		
		em = emf.createEntityManager();
		Trade trade = em.find(Trade.class, t.getTradeId());
		em.getTransaction().begin();
		em.remove(trade);
		em.getTransaction().commit();	
		em.close();
	}

	public Set<Trade> read(Person person){
		
		tradeSet = new HashSet<Trade>();
		em = emf.createEntityManager();
		List<Trade> results = em.createQuery("SELECT o FROM Trade o WHERE o.person2.personId =:Id")
               .setParameter("Id", person.getPersonId()).getResultList();
		for(Trade trade : results){
			tradeSet.add(trade);
		}
		
		results = em.createQuery("SELECT o FROM Trade o WHERE o.person1.personId =:Id")
	               .setParameter("Id", person.getPersonId()).getResultList();
			for(Trade trade : results){
				tradeSet.add(trade);
			}						
		return tradeSet;
	}
	
	
}
