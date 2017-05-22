package com.fdmgroup.fileiotddwalthrough.jdbc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.entities.UserFactory;
import com.fdmgroup.fileiotddwalthrough.jdbc.ConnectionFactory;
import com.fdmgroup.fileiotddwalthrough.jdbc.DBReadCommand;

public class DBReadCommandTest {

	private DBReadCommand reader;
	private ConnectionFactory mockConnectionFactory;
	private UserFactory mockUserFactory;
	private Connection mockConnection;
	private Statement mockStatement;
	private ResultSet mockResultSet;
	
	@Before
	public void setup() throws SQLException {
		mockConnectionFactory = mock(ConnectionFactory.class);
		mockUserFactory = mock(UserFactory.class);
		reader = new DBReadCommand(mockConnectionFactory, mockUserFactory);
		
		mockConnection = mock(Connection.class);
		when(mockConnectionFactory.getConnection()).thenReturn(mockConnection);
		mockStatement = mock(Statement.class);
		when(mockConnection.createStatement()).thenReturn(mockStatement);
		mockResultSet = mock(ResultSet.class);
		when(mockStatement.executeQuery(anyString())).thenReturn(mockResultSet);
	}
	
	@Test
	public void test_read_returnTypeList() {
		//A
		//A 
		List<User> users = reader.read();
		//A
		assertTrue(users instanceof List<?>);
	}

	@Test
	public void test_read_openConnection() {
		//A
		//A
		reader.read();
		//A
		verify(mockConnectionFactory, times(1)).getConnection();
	}
	
	@Test
	public void test_read_createStatement() throws SQLException {
		//A
		//A
		reader.read();
		//A
		verify(mockConnection, times(1)).createStatement();
	}
	
	@Test
	public void test_read_executeQuery() throws SQLException {
		//A
		//A
		reader.read();
		//A
		verify(mockStatement, times(1)).executeQuery(anyString());
	}
	
	@Test
	public void test_read_createUser() throws SQLException {
		//A
		when(mockResultSet.next()).thenReturn(true).thenReturn(false);
		when(mockResultSet.getString("username")).thenReturn("username");
		when(mockResultSet.getString("password")).thenReturn("password");
		when(mockResultSet.getString("role")).thenReturn("role");
		//A
		reader.read();
		//A
		verify(mockUserFactory, times(1)).createUser("username","password","role");
	}
	
	@Test
	public void test_read_closeConnection() throws SQLException {
		//A
		//A
		reader.read();
		//A
		verify(mockConnection, times(1)).close();
	}
}
