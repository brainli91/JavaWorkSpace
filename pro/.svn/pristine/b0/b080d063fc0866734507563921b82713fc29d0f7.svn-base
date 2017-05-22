package com.fdmgroup.tradingplatform.dao;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.Role;

public class RoleRAMDAO implements IStoreable<Role> {

	private Set<Role> roleSet;	
	
	private EntityManagerFactory emf;
	private EntityManager em;

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void create(Role t) {
		
		em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Role read(int id) {
		
		em = emf.createEntityManager();
		Role role = em.find(Role.class, id);
		em.close();
		return role;
	}

	@Override
	public void update(Role t) {
		
		em = emf.createEntityManager();
		Role role = em.find(Role.class, t.getRoleId());
		em.getTransaction().begin();
		em.remove(role);
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void delete(Role t) {
		
		em = emf.createEntityManager();
		Role role = em.find(Role.class, t.getRoleId());
		em.getTransaction().begin();
		em.remove(role);
		em.getTransaction().commit();	
		em.close();
	}

}
