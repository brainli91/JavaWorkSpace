package com.fdmgroup.auth;


import org.mindrot.jbcrypt.BCrypt;


public class PasswordHash {

	
	public PasswordHash() {
		super();
	}


	/**
	 * This method hashes the users password with a random salt and returns the result as a HashedPassword object.
	 * @param password
	 * @return
	 */
	 public String hash(String password){
		 String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		 
		 return hashedPassword;
		 
	 }
	 
	 
	 /**
	  * This method verifies entered password with hashed password.
	  * @param hashed
	  * @param password
	  * @param salt
	  * @return
	  */
	 public boolean verifyPassword(String hashed, String password){
		 return BCrypt.checkpw(password, hashed);
		 
		 
	 }
	
	
}
