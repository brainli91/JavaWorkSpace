package com.fdm.tp.validate;

import com.fdm.exceptions.RegistrationException;

import com.fdm.tp.model.storable.User;

public class RegistrationValidator implements IValidator {

	// add custom exception to be thrown (create it first)

	public void validate(User user)throws RegistrationException{
		
		//check if user already exists, using userName;
		//check if user contains all the necessary info maybe
		
		if ( !(userHasRightDetails(user)) ) {	
			throw new RegistrationException("Incorrect user details!");
		}
		
		if (  !(userIsNotDuplicate(user) ) ) {
			throw new RegistrationException("User already exists!");
		}

	} 

	public boolean userIsNotDuplicate(User user) {

		return true;
	}

	public boolean userHasRightDetails(User user) {

		return true;
	}

}
