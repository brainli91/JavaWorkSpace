package com.fdm.tp.model.storage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInput;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.fdm.tp.model.storable.User;

public class LoadUsersDataTest {

	@Spy
	LoadUsersData spyLoad;
	

	@Mock
	ObjectInput mockInput;
	
	@Mock
	Map<String, User> mockMap;
	 File testFile = new File("testFile.txt");
	
	@Before
	public void setup() {
		spyLoad = new LoadUsersData();
		MockitoAnnotations.initMocks(this);
	
	}
	
	@After
	public void clearup() {
		//testFile.delete();	
	}
	
	@Test
	public void testThatMethodDeserializeMapCallsGetObjectInputAndReadObject() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		doReturn(mockInput).when(spyLoad).getObjectInput("testFile.txt");
		doReturn(mockMap).when(mockInput).readObject();
		
		spyLoad.deserializeUsersMap("testFile.txt");
		verify(spyLoad).getObjectInput("testFile.txt"); 
		verify(mockInput).readObject(); 
	}
	
	@Test
	public void testWhenReadObjectThrowsExceptioncloseOutPutIsCalled() throws IOException, ClassNotFoundException{
		doThrow(new IOException()).when(mockInput).readObject();
		doReturn(mockInput).when(spyLoad).getObjectInput("");
		
		spyLoad.deserializeUsersMap("");
		verify(spyLoad).closeObjectInput(mockInput);;
	}

	@Test
	public void testWhenGetObjectInputThrowsExceptionReadIsNotCalled() throws FileNotFoundException, IOException, ClassNotFoundException{
		doThrow(new FileNotFoundException()).when(spyLoad).getObjectInput("");
		//assertFalse(spyLoad.deserializeUsersMap(""));
		verify(mockInput,never()).readObject();
	}
	
	@Test
	public void testWhenReadObjectThrowsExceptionNullIsReturned() throws  ClassNotFoundException, IOException{
		doThrow(new ClassNotFoundException()).when(mockInput).readObject();
		//assertFalse(spyLoad.deserializeUsersMap(""));
		spyLoad.deserializeUsersMap("");
	
		Assert.assertEquals(null, spyLoad.deserializeUsersMap(""));
		
	}
	
	@Test
	public void testGetObjectInputReturnsAnObjectInputStream() throws FileNotFoundException, IOException {
		//assertFalse(spyLoad.deserializeUsersMap(""));
		doReturn(mockInput).when(spyLoad).getObjectInput("testFile.txt");
		
		spyLoad.deserializeUsersMap("");
		Assert.assertEquals(mockInput.getClass(), spyLoad.getObjectInput("testFile.txt").getClass());
	}
	
}
