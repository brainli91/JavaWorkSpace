package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import dao.IStorage;
import entities.Company;
import dto.IStorable;
import exceptions.StorableNotFoundException;

public class Company_DAO_JPA implements IStorage<Company, Integer, Integer> {
	@Override
	public Company create(Company company) throws StorableNotFoundException {
		// TODO Auto-generated method stub
				if(company==null)
					throw new StorableNotFoundException("This Company does not exist");
				
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				em.persist(company);
				em.getTransaction().commit();
				
				
				em.close();
				emf.close();
				return company;
	}

	@Override
	public Company read(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		try{
		Company result = em.find(Company.class, id);
		
		em.close();
		emf.close();
		return result;
		
		}catch (NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This Company does not exist");
		}
	}

	@Override
	public void update(Company oldcompany, Company newcompany)
			throws StorableNotFoundException {
		if(oldcompany == null || newcompany == null)
			throw new StorableNotFoundException("This company does not exist");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		Company result = em.find(Company.class, oldcompany.getCompanyId());
		
		em.getTransaction().begin();
		
		result.setName(newcompany.getName());
		result.setStartingPrice(newcompany.getStartingPrice());
		result.setStockId(newcompany.getStockId());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		Company_DAO_JPA dao = new Company_DAO_JPA();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		if(em.find(Company.class, id)==null)
			throw new StorableNotFoundException("This company does not exist");
		
		em.getTransaction().begin();
		em.remove(em.find(Company.class, id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
