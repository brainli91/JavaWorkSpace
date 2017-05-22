package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import dao.IStorage;
import dto.IStorable;
import entities.Person;
import exceptions.StorableNotFoundException;

public class Person_DAO_JPA implements IStorage<Person, String, Integer>{

	@Override
	public Person create(Person user) throws StorableNotFoundException {
		if(user==null)
			throw new StorableNotFoundException("This user does not exist");

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		return user;
	}

	@Override
	public Person read(String uniquevalue) throws StorableNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Person read(Integer id) throws StorableNotFoundException{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		try{
		Person result = em.find(Person.class, id);
		
		em.close();
		emf.close();
		return result;
		
		}catch (NoResultException e){
			e.printStackTrace();
			throw new StorableNotFoundException("This user does not exist");
			
		}
	}

	@Override
	public void update(Person olduser, Person newuser)
			throws StorableNotFoundException {
		
		if(olduser == null || newuser == null)
			throw new StorableNotFoundException("This user does not exist");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		Person result = em.find(Person.class, olduser.getPersonId());
		
		em.getTransaction().begin();
		result.setPassword(newuser.getPassword());
		result.setFirstName(newuser.getFirstName());
		result.setLastName(newuser.getLastName());
		result.setUserName(newuser.getUserName());
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

	@Override
	public void delete(Integer id) throws StorableNotFoundException {
	User_DAO_JPA dao = new User_DAO_JPA();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TradingPlatformProject1");

		EntityManager em = emf.createEntityManager();
		
		if(em.find(Person.class, id)==null)
			throw new StorableNotFoundException("This user does not exist");
		
		em.getTransaction().begin();
		em.remove(em.find(Person.class, id));
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
