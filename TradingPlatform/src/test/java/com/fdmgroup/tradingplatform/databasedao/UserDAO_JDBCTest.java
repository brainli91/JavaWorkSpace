package com.fdmgroup.tradingplatform.databasedao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import com.fdmgroup.tradingplatform.model.User;



public class UserDAO_JDBCTest {

	UserDAO_JDBC userDAO;
	
	@Mock
	DataSource pool;
	
	@Mock
	User user;
	
	@Mock 
	Connection connection;
	
	@Mock
	PreparedStatement ps;
	
	@Mock
	ResultSet rs;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		//userDAO = new UserDAO_JDBC();
	}

	@Test
	public void testMethodsCheckOutAndExecuteAreCalledWhenGetIsCalled() {

	}

}
