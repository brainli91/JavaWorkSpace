package com.fdm.tp.model.storage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ConnectionPoolTest {
	
	ConnectionPool conPool;
	
	@Mock
	Connection con;
	
	@Mock
	List<Connection> availableList;
	
	@Mock
	List<Connection> UsedList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		conPool = ConnectionPool.getInstance("","","");
	}

	@Test
	public void testThatConnectionPoolReturnsTheSameObjectWhenItsCalledTwice() {
		assertSame(conPool,ConnectionPool.getInstance("","",""));
	}
	
	@Test
	public void testGetInstanceReturnsANotNullObjectWhenTheGetInstanceMethodIsCalled(){
		assertNotNull(conPool);
	
	}
	
	
	@Test
	public void testMethodAvailableCountReturnsOneWhenConnectionPoolIsInitialised(){
		conPool.availableCount();
		Assert.assertEquals(1, conPool.availableCount());
	}
	
/*
	@Test
	public void testMethodCheckoutReturnsAConnectionObject() throws SQLException{
		//doReturn(con).when(con).getConnection();
		Assert.assertEquals(con.getClass(), conPool.checkout().getClass());
	}
	*/
	
	

}
