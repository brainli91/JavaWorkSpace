package com.fdmgroup.fileiotddwalthrough.jpa;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.fileiotddwalthrough.entities.User;

public class UserORMWriteCommandTest {

	private UserORMWriteCommand writer;
	private EntityManagerFactory mockEntityManagerFactory;
	private User mockUser;
	private EntityManager mockEntityManager;
	private EntityTransaction mockEntityTransaction;
	
	@Before
	public void setup() {
		mockEntityManagerFactory = mock(EntityManagerFactory.class);
		writer = new UserORMWriteCommand(mockEntityManagerFactory);
		
		mockUser = mock(User.class);
		mockEntityManager = mock(EntityManager.class);
		when(mockEntityManagerFactory.createEntityManager()).thenReturn(mockEntityManager);
		mockEntityTransaction = mock(EntityTransaction.class);
		when(mockEntityManager.getTransaction()).thenReturn(mockEntityTransaction);
	}
	
	@Test
	public void test_write_createEntityManager() {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockEntityManagerFactory, times(1)).createEntityManager();
	}
	
	@Test
	public void test_write_createEntityTransaction() {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockEntityManager, times(1)).getTransaction();
	}
	
	@Test
	public void test_write_TransactionBegin() {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockEntityTransaction, times(1)).begin();
	}
	
	@Test
	public void test_write_TransactionCommit() {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockEntityTransaction, times(1)).commit();
	}
	
	@Test
	public void test_write_persistEntityManager() {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockEntityManager, times(1)).persist(mockUser);
	}
	
	@Test
	public void test_write_closeEntityManager() {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockEntityManager, times(1)).close();
	}
}
