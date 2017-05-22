package com.fdmgroup.fileiotddwalthrough.jpa;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;

public class UserORMReadCommandTest {
	private UserORMReadCommand reader;
	private EntityManagerFactory mockEntityManagerFactory;
	private UserFactory mockUserFactory;
	private EntityManager mockEntityManager;
	private Query mockQuery;
	private List<?> mockListOfUsers;
	
	@Before
	public void setup() {
		mockEntityManagerFactory = mock(EntityManagerFactory.class);
		mockUserFactory = mock(UserFactory.class);
		reader = new UserORMReadCommand(mockEntityManagerFactory, mockUserFactory);
		
		mockEntityManager = mock(EntityManager.class);
		when(mockEntityManagerFactory.createEntityManager()).thenReturn(mockEntityManager);
		mockQuery = mock(Query.class);
		when(mockEntityManager.createNativeQuery(anyString(), eq(User.class))).thenReturn(mockQuery);
		mockListOfUsers = mock(List.class);
		when(mockQuery.getResultList()).thenReturn(mockListOfUsers);
	}

	@Test
	public void test_read_returnTypeList() {
		// A
		// A
		List<User> users = reader.read();
		// A
		assertTrue(users instanceof List<?>);
	}

	@Test
	public void test_read_createEntityManager() {
		// A
		// A
		reader.read();
		// A
		verify(mockEntityManagerFactory, times(1)).createEntityManager();
	}

	@Test
	public void test_read_createQuery() {
		// A
		// A
		reader.read();
		// A
		verify(mockEntityManager, times(1)).createNativeQuery(anyString(), eq(User.class));
	}

	@Test
	public void test_read_closeEntityManager() {
		// A
		// A
		reader.read();
		// A
		verify(mockEntityManager, times(1)).close();
	}

}
