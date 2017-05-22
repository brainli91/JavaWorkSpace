package com.fdm.tp.model.storage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import com.fdm.tp.model.storable.User;

public class MapUserStorageSingletonTest {
	
	//MapUserStorageSingleton musSingleton;
	
	MapUserStorageSingleton userStorage;
	
	@Mock User user;
	@Mock Map<String,User> mockmap;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		userStorage = MapUserStorageSingleton.getInstance();
		userStorage.setMap(mockmap);
	}
	
	
	//phase 1 tests
	@Test
	public void testGetInstanceReturnsANotNullObjectWhenTheGetInstanceMethodIsCalled(){
		assertNotNull(userStorage);
	
	}
	
	@Test
	public void testGetInstanceReturnsTheSameInstanceWhenItIsCalledTwice(){
		assertSame(userStorage,MapUserStorageSingleton.getInstance());
	}
	
	//phase 2 tests
	@Test
	public void testAddMethodCallsThePutMethodFromMap(){
		when(user.getUserName()).thenReturn("mahamed");
		userStorage.addUser(user);
		verify(mockmap).put("mahamed",user);
	}
	
	
	//phase 3 tests
	@Test
	public void testRemoveMethodCallsTheRemoveMethodFromMap(){
		userStorage.remove("mahamed");
		verify(mockmap).remove("mahamed");
	}
	
	@Test
	public void testGetMethodCallsTheGetMethodFromMap(){
		userStorage.get("mahamed");
		verify(mockmap).get("mahamed");
	}
	
	
}
