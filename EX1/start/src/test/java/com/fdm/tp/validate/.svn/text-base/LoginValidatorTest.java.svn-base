package com.fdm.tp.validate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.fdm.exceptions.LoginException;
import com.fdm.tp.model.storable.User;
import com.fdm.tp.model.storage.IStorage;

public class LoginValidatorTest {
	
	
	LoginValidator logVal;
	

	User testUser;

	IStorage storage;
	/*
	@Test
	public void test() {
		
	}
	*/

	@Before
	public void setup(){	
		storage = mock(IStorage.class);	
		testUser = mock(User.class);
		logVal = spy(new LoginValidator(storage));
	}
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testValidatorThrowsExceptionWhenUserDoesNotExists() throws LoginException {
    	doReturn(-1).when(logVal).isCorrectUser(testUser);

        thrown.expect(LoginException.class);
        thrown.expectMessage("User: "+testUser.getUserName()+" does not exists");
    	logVal.validate(testUser);
    }
    
    @Test
    public void testValidatorThrowsExceptionWhenUserPasswordDoesNotMatch() throws LoginException {
    	doReturn(0).when(logVal).isCorrectUser(testUser);

        thrown.expect(LoginException.class); 
        thrown.expectMessage("Incorrect password!"); 
    	logVal.validate(testUser);
    } 
	
    @Test
    public void testValidatorDoesNotThrowAnExceptionWhenCorrectUserIsGiven() throws LoginException {
    	doReturn(1).when(logVal).isCorrectUser(testUser);

    	logVal.validate(testUser); 
    }
    
    @Test
    public void testIsCorrecUserMethodReturnsOneWhenCorrectUserIsGiven() throws LoginException {
    	when(storage.get(testUser.getUserName())).thenReturn(testUser);

    	assertTrue(logVal.isCorrectUser(testUser)==1);
    }
    
    @Test
    public void testIsCorrecUserMethodReturnsNegativeOneWhenUserIsNotInStorage() throws LoginException {
    	when(storage.get(testUser.getUserName())).thenReturn(null);

    	assertTrue(logVal.isCorrectUser(testUser)==-1);
    }
    
//    @Test
//    public void testIsCorrecUserMethodReturnsZeroWhenUserPasswordIsIncorrect() throws LoginException {
//    	
//    
//    	when(storage.get(testUser.getUserName())).thenReturn(testUser);
//    	testUser.setPassword("myPass");
//    	when(testUser.getPassword()).thenReturn(null);
//
//    	assertTrue(logVal.isCorrectUser(testUser)==0);
//    }
    
}
