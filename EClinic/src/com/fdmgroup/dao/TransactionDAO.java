package com.fdmgroup.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.entity.Transaction;

public class TransactionDAO implements IStorage<Transaction>{

	@Autowired
	DBConnection dbConnection;
	
	
	public TransactionDAO() {
		super();
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public Transaction read(long id) {
		EntityManager em =  dbConnection.getEntityManager();
		return em.find(Transaction.class, id);
	}

	@Override
	public Transaction create(Transaction transaction) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(transaction);
		em.getTransaction().commit();
		return transaction;
	}

	@Override
	public Transaction update(Transaction transaction) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.merge(transaction);
		em.getTransaction().commit();
		return transaction;
	}

	@Override
	public boolean delete(Transaction transaction) {
		EntityManager em = dbConnection.getEntityManager();
		if(em.contains(transaction)){
			em.getTransaction().begin();
			em.remove(transaction);
			em.getTransaction().commit();
			return true;
		}
		return false;
 	}

	public List<Transaction> findAll (){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("transaction.findAll");
		List<Transaction> transaction = query.getResultList();
		return transaction;
	}
	
	public Transaction findByUserId (long id){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("transaction.findByUserId");
		query.setParameter("id", id);
		List<Transaction> transactions = query.getResultList();
		if(transactions.isEmpty() && transactions.size()!= 1){
			return null;
		}
		return transactions.get(0);
	}
	
	public List<Transaction> findByDate (Date date){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("transaction.findByDate");
		query.setParameter("date",date);
		List<Transaction> transactions = query.getResultList();
		return transactions;
	}
	
}
