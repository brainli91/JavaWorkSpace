package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import dao.IStorage;
import dto.IStorable;
import entities.Request;
import exceptions.NoUserException;
import exceptions.StorableNotFoundException;

public class Request_DAO_JPA implements IStorage<Request, Integer, Integer>{

	@Override
	public IStorable create(Request request) throws StorableNotFoundException {
		// TODO Auto-generated method stub
				if(request==null)
					throw new StorableNotFoundException("This request does not exist");
				
				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				em.persist(request);
				em.getTransaction().commit();
				
				
				em.close();
				emf.close();
				return request;
	}

	@Override
	public Request read(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		try{
			Request result = em.find(Request.class, id);
		
		em.close();
		emf.close();
		return result;
		
		}catch (NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This request does not exist");
		}
	}

	@Override
	public void update(Request oldrequest, Request newrequest)
			throws StorableNotFoundException {
		if(oldrequest == null || newrequest == null)
			throw new StorableNotFoundException("This request does not exist");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		Request result = em.find(Request.class, oldrequest.getRequestId());
		
		em.getTransaction().begin();
		
		result.setBuySell(newrequest.getBuySell());
		result.setLimitPrice(newrequest.getLimitPrice());
		result.setMinimumShares(newrequest.getMinimumShares());
		result.setRequestDate(newrequest.getRequestDate());
		result.setPerson(newrequest.getPerson());		
		result.setShares(newrequest.getShares());
		result.setSharesFilled(newrequest.getSharesFilled());
		result.setStockId(newrequest.getStockId());
		result.setStopPrice(newrequest.getStopPrice());
		result.setTimeInForce(newrequest.getTimeInForce());
		result.setStatus(newrequest.getStatus());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		Request_DAO_JPA dao = new Request_DAO_JPA();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		if(em.find(Request.class, id)==null)
			throw new StorableNotFoundException("This request does not exist");
		
		em.getTransaction().begin();
		em.remove(em.find(Request.class, id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
