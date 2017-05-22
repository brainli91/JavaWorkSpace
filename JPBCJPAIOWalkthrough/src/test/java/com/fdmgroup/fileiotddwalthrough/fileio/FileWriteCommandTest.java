package com.fdmgroup.fileiotddwalthrough.fileio;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.fdmgroup.fileiotddwalthrough.entities.User;
import com.fdmgroup.fileiotddwalthrough.fileio.BufferedWriterFactory;
import com.fdmgroup.fileiotddwalthrough.fileio.FileWriteCommand;

import static org.mockito.Mockito.*;

public class FileWriteCommandTest {

	private BufferedWriterFactory mockBufferedWriterFactory;
	private FileWriteCommand writeCommand;
	private User mockUser;
	private BufferedWriter mockBufferedWriter;
	@Before
	public void setUp() throws IOException{
		mockBufferedWriterFactory = mock(BufferedWriterFactory.class);
		writeCommand = new FileWriteCommand(mockBufferedWriterFactory);
		
		mockBufferedWriter = mock(BufferedWriter.class);
		when(mockBufferedWriterFactory.createBufferedWriter()).thenReturn(mockBufferedWriter);
	}

	@Test
	public void test_WriteMethod_CallsCreateBufferedWriterMethodOfBufferedWriterFactory_WhenCalled() throws IOException {
		writeCommand.write(mockUser);
		//Assert
		verify(mockBufferedWriterFactory, times(1)).createBufferedWriter();
	}

	@Test
	public void test_WriteMethod_CallsWriteLineMethodOfBufferedWriterGivenToItFromTheBufferedWriterFactory() throws IOException{
		//Arrange
		//Act
		writeCommand.write(mockUser);
		//Assert
		verify(mockBufferedWriter,times(1)).write(anyString());
	}
	
	@Test
	public void test_WriteMethod_CallsWriteLineMethodOfBufferedWriterGivenToItFromTheBufferedWriterFactory_WithUsernamePasswordRole() throws IOException{
		//Arrange
		when(mockUser.getUsername()).thenReturn("testUsername");
		when(mockUser.getPassword()).thenReturn("testPassword");
		when(mockUser.getRole()).thenReturn("testRole");
		//Act
		writeCommand.write(mockUser);
		//Assert
		verify(mockBufferedWriter,times(1)).write("testUsername, testPassword, testRole");
	}
	
	//Next tests
	//@Test - check that the newLine() method of mockBufferedReader is called
	//@Test - check that the close() method of mockBufferedReader is called
}
