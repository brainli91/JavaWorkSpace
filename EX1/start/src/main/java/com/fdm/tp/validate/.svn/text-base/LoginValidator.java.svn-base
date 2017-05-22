package com.fdm.tp.validate;

import org.apache.log4j.Logger;

import com.fdm.exceptions.LoginException;
import com.fdm.tp.main.Start;
import com.fdm.tp.model.storable.User;
import com.fdm.tp.model.storage.IStorage;
	
public class LoginValidator implements ILoginValidator{
	

	private IStorage storage;
	
	Logger log = Logger.getLogger(Start.class.getName()); 
	
	public LoginValidator(IStorage storage) {
		this.storage = storage;
	}
	//check if the given user is in the user storage with a matching password
	public void validate(User user) throws LoginException {
		
		log.debug("Validating user for login...");
		if (isCorrectUser(user) == -1){
			throw new LoginException("User: "+user.getUserName()+" does not exists");
		}
		
		if (isCorrectUser(user) == 0){
			throw new LoginException("Incorrect password!");
		}
		
	}
	
	//check that the userName is a key in the map and the password its matching value
	//return -1 if the user doesn't exist
	//return 0 if the password is incorrect
	//return 1 for correct user
	public int isCorrectUser(User userToValidate){
		User returnedUser = storage.get(userToValidate.getUserName());
		if (returnedUser==null)
			return -1;
		if (returnedUser.getPassword() != userToValidate.getPassword())
			return 0;
	
		return 1;
	}

}
