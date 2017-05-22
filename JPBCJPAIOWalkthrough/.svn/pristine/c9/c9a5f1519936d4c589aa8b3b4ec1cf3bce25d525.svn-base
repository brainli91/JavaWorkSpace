package com.fdmgroup.fileiotddwalthrough.jdbc;

import java.sql.Connection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.fileiotddwalthrough.jdbc.ConnectionFactory;

public class ConnectionFactoryTest {

	private ConnectionFactory connectionfactory;
	
	@Before
	public void setup() {
		connectionfactory = new ConnectionFactory();
	}
	
	@Test
	public void test_getConnection_ReturnAConnection() {
		Connection connection = connectionfactory.getConnection();
		assertTrue(connection instanceof Connection);
	}
}