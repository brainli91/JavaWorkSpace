package com.fdm.tp.model.storage;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.fdm.tp.controller.IController;
import com.fdm.tp.model.storable.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.fdm.tp.model.storable.User;

public class UsersDAOTest {
	
	UsersDAO dao;
	
	@Mock
	ConnectionPool pool;
	
	@Mock
	User user;
	
	@Mock 
	Connection connection;
	
	@Mock
	CallableStatement callst;
	
	@Mock
	PreparedStatement ps;
	
	@Mock
	ResultSet rs;
	
	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		dao = new UsersDAO(pool);
	}

	@Test
	public void testMethodsCheckOutAndExecuteAreCalledWhenAddUserIsCalled() throws SQLException {
		doReturn(connection).when(pool).checkout();
		doReturn(callst).when(connection).prepareCall(anyString());
		
	
		dao.addUser(user);
		
		verify(pool).checkin(connection);
		verify(callst).setString(1, user.getUserName());
		verify(callst).executeUpdate();
	}
	
	@Test
	public void testAllTheSetMethodsForUserAreCalled() throws SQLException {
		doReturn(connection).when(pool).checkout();
		doReturn(callst).when(connection).prepareCall(anyString());
	
		dao.addUser(user);
		
		verify(callst).setString(1, user.getUserName());
		verify(callst).setString(2, user.getPassword());
		verify(callst).setString(3, user.getFirstName());
		verify(callst).setLong(5, user.getRole());
		verify(callst).setLong(6, 0);
	}
	
	@Test
	public void testThatUserSetMethodsAreNotCalledAndCheckinMethodIsCalledWhenExceptionIsThrown() throws SQLException{
		doThrow(new SQLException()).when(pool).checkout();
		dao.addUser(user);
		verify(callst,never()).setString(1, user.getUserName());
		verify(callst,never()).setString(2, user.getPassword());
		verify(callst,never()).setString(3, user.getFirstName());
		verify(callst,never()).setLong(5, user.getRole());
		verify(callst,never()).setLong(6, 0);
		verify(pool).checkin(null);
	}
	
	@Test
	public void testMethodsCheckOutAndExecuteAreCalledWhenRemoveIsCalled() throws SQLException{
		doReturn(connection).when(pool).checkout();
		doReturn(callst).when(connection).prepareCall(anyString());
		
	
		dao.remove(""); 
		verify(pool).checkout();
		verify(callst).execute();
	}
	
	@Test
	public void testThatExecuteInRemoveMethodIsNotCalledWhenExceptionIsThrown() throws SQLException{
		doThrow(new SQLException()).when(pool).checkout();
		verify(callst,never()).setString(1, user.getUserName());
		verify(callst,never()).execute();
		
		dao.remove(""); 
		verify(pool).checkin(null);
	}
	
	@Test
	public void testMethodsCheckOutAndExecuteAreCalledWhenGetIsCalled() throws SQLException{
		doReturn(connection).when(pool).checkout();
		doReturn(ps).when(connection).prepareStatement(anyString());
		doReturn(rs).when(ps).executeQuery();
		//ps.executeQuery()
		doReturn(true).when(rs).next();
	
		dao.get(""); 
		verify(pool).checkout();
		verify(ps).executeQuery(); 
	}
	
	@Test
	public void testMethodsGetReturnsUserObject() throws SQLException{
		doReturn(connection).when(pool).checkout();
		doReturn(ps).when(connection).prepareStatement(anyString());
		doReturn(rs).when(ps).executeQuery();
		doReturn(true).when(rs).next();
		
		
		Assert.assertEquals(User.class,dao.get("").getClass());
	}
}
