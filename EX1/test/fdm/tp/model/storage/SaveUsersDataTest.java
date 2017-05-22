package com.fdm.tp.model.storage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutput;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.fdm.tp.model.storable.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class SaveUsersDataTest {
 
	@Spy
	SaveUsersData spySave;
	
	@Mock
	Map<String, User> mockMap;
	
	@Mock
	ObjectOutput mockOutput;
	
	@Before
	public void setUp(){
		spySave = new SaveUsersData();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testObjectOutputCallsWriteAndFlushFromSerializer() throws FileNotFoundException, IOException{
		doReturn(mockOutput).when(spySave).getObjectOutput("");
		assertTrue(spySave.serializeUsersMap(mockMap, ""));
		verify(mockOutput).writeObject(mockMap);
		verify(mockOutput).flush();
	}
	
	@Test
	public void testWhenGetObjectOutputThrowsExceptionAndFlushAndWriteAreNotCalled() throws FileNotFoundException, IOException{
		doThrow(new FileNotFoundException()).when(spySave).getObjectOutput("");
		assertFalse(spySave.serializeUsersMap(mockMap, ""));
		verify(mockOutput,never()).writeObject(mockMap);
		verify(mockOutput,never()).flush();
	}

	@Test
	public void testWhenWriteObjectThrowsExceptionFlushIsNotCalledAndcloseOutPutIsCalled() throws IOException{
		doThrow(new IOException()).when(mockOutput).writeObject(mockMap);
		doReturn(mockOutput).when(spySave).getObjectOutput("");
		
		verify(mockOutput,never()).flush();
		spySave.serializeUsersMap(mockMap, "");
		verify(spySave).closeOutput(mockOutput);
	}
	
}
