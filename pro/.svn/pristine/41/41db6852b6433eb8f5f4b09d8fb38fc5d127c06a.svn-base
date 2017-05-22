package com.fdmgroup.tradingplatform.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.Person;

public class CompanyRAMDAO implements IStoreable<Company> {

	private Set<Company> companySet;
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Company t) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Company read(int id) {
		
		em = emf.createEntityManager();
		Company company = em.find(Company.class, id);
		em.close();
		return company;
	}

	@Override
	public void update(Company t) {
		
		em = emf.createEntityManager();
		Company company = em.find(Company.class, t.getCompanyId());
		em.getTransaction().begin();
		em.remove(company);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Company t) {
		
		em = emf.createEntityManager();
		Company company = em.find(Company.class, t.getCompanyId());
		em.getTransaction().begin();
		em.remove(company);
		em.getTransaction().commit();	
		em.close();
	}

	public Company readByStockId(int id){
		em = emf.createEntityManager();
		
		List<Company> results = em.createQuery("SELECT c FROM Company c WHERE c.stockId =:Id")
				.setParameter("Id", id).getResultList();
		if(results.size() == 0){
			return null;
		}
		else {
			return results.get(0);
		}
		
	}
	
}
