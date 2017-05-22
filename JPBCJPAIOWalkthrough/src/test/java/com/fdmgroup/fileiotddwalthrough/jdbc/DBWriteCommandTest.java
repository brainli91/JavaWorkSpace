package com.fdmgroup.fileiotddwalthrough.jdbc;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.jdbc.ConnectionFactory;
import com.fdmgroup.fileiotddwalthrough.jdbc.DBWriteCommand;

public class DBWriteCommandTest {

	private DBWriteCommand writer;
	private ConnectionFactory mockConnectionFactory;
	private User mockUser;
	Connection mockConnection;
	PreparedStatement mockPreparedStatement;
	
	@Before
	public void setup() throws SQLException {
		mockConnectionFactory = mock(ConnectionFactory.class);
		writer = new DBWriteCommand(mockConnectionFactory);
		mockUser = mock(User.class);
		
		mockConnection = mock(Connection.class);
		when(mockConnectionFactory.getConnection()).thenReturn(mockConnection);
		mockPreparedStatement = mock(PreparedStatement.class);
		when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
	}

	@Test
	public void test_write_openConnection() {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockConnectionFactory, times(1)).getConnection();
	}
	
	@Test
	public void test_write_createPreparedStatement() throws SQLException {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockConnection, times(1)).prepareStatement(anyString());
	}
	
	@Test
	public void test_write_executeUpdate() throws SQLException {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockPreparedStatement, times(1)).executeUpdate();
	}
	
	@Test
	public void test_write_closeConnection() throws SQLException {
		//A
		//A
		writer.write(mockUser);
		//A
		verify(mockConnection, times(1)).close();
	}
}
