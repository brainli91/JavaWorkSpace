package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import dao.IStorage;
import dto.IStorable;
import dto.RequestDTO;
import dto.TradeDTO;
import entities.Trade;
import exceptions.StorableNotFoundException;

public class Trade_DAO_JPA implements IStorage<Trade, Integer, Integer> {
	
	
	@Override
	public Trade create(Trade trade) throws StorableNotFoundException {
		// TODO Auto-generated method stub
				if(trade==null)
					throw new StorableNotFoundException("This trade does not exist");

				
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

				EntityManager em = emf.createEntityManager();
				
				em.getTransaction().begin();
				em.persist(trade);
				em.getTransaction().commit();
				
				
				em.close();
				emf.close();
				return trade;
	}

	@Override
	public Trade read(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		try{
		Trade result = em.find(Trade.class, id);
		
		em.close();
		emf.close();
		return result;
		
		}catch (NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This request does not exist");
			
		}
	}

	@Override
	public void update(Trade oldtrade, Trade newtrade)
			throws StorableNotFoundException {
		if(oldtrade == null || newtrade == null)
			throw new StorableNotFoundException("This request does not exist");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		Trade result = em.find(Trade.class, oldtrade.getTradeId());
		
		em.getTransaction().begin();
		
		em.getTransaction().commit();
		
		result.setPerson1(newtrade.getPerson1());
		result.setPerson2(newtrade.getPerson2());
		result.setPriceTotal(newtrade.getPriceTotal());
		result.setRequest1(newtrade.getRequest1());
		result.setRequest2(newtrade.getRequest2());
		result.setSharePrice(newtrade.getSharePrice());
		result.setShares(newtrade.getShares());
		result.setStockId(newtrade.getStockId());
		result.setTransactionTime(newtrade.getTransactionTime());
		
		
		em.close();
		emf.close();
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		Trade_DAO_JPA dao = new Trade_DAO_JPA();
		
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		if(em.find(Trade.class, id)==null)
			throw new StorableNotFoundException("This trade does not exist");
		
		em.getTransaction().begin();
		em.remove(em.find(Trade.class, id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
