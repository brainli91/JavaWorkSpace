package com.fdm.tp.validate;


import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.fdm.exceptions.RegistrationException;
import com.fdm.tp.model.storable.User;

public class RegistrationValidatorTest {

	@Spy
	RegistrationValidator regVal;

	@Mock
	User testUser;

	@Before
	public void setUp() {
		regVal = new RegistrationValidator();
		MockitoAnnotations.initMocks(this);
	}


//	@Test(expected = RegistrationException.class)
//	public void testValidatorThrowsExceptionWhenUserIsNotValid() throws RegistrationException {
//		doReturn(true).when(regVal).userIsNotDuplicate(testUser);
//		doReturn(false).when(regVal).userHasRightDetails(testUser);
//		regVal.validate(testUser);
//		 expected.expectMessage("");
//
//	}

	@Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testValidatorThrowsExceptionWhenUserDoesNotHaveCorrectDetails() throws RegistrationException {
    	doReturn(true).when(regVal).userIsNotDuplicate(testUser);
		doReturn(false).when(regVal).userHasRightDetails(testUser);
        thrown.expect(RegistrationException.class);
        thrown.expectMessage("Incorrect user details!");
    	regVal.validate(testUser);
    }
    
    @Test
    public void testValidatorThrowsExceptionWhenUserAlreadyExists() throws RegistrationException {
    	doReturn(false).when(regVal).userIsNotDuplicate(testUser);
		doReturn(true).when(regVal).userHasRightDetails(testUser);
        thrown.expect(RegistrationException.class);
        thrown.expectMessage("User already exists!");
    	regVal.validate(testUser);
    }
	
    @Test
    public void testValidatorDoesNotThrowAnExceptionWhenCorrectUserIsGiven() throws RegistrationException {
    	doReturn(true).when(regVal).userIsNotDuplicate(testUser);
		doReturn(true).when(regVal).userHasRightDetails(testUser);

    	regVal.validate(testUser); 
    }
    
  
}

// test1 