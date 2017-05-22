package userManager;

import jpa.User_DAO_JPA;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import entities.Person;
import exceptions.StorableNotFoundException;

public class JPAUserActions {
	
	User_DAO_JPA dao = new User_DAO_JPA();
	
public Person Login(String username, String password) throws StorableNotFoundException {
		
		if (dao.read(username) == null)
			throw new StorableNotFoundException("This user does not exist.");
		
		if (dao.read(username).getPassword().equals(password)) {
			PropertyConfigurator.configure("log4j.properties");
			log.info(username + " has logged in");
			return dao.read(username);
		} 
		
		else
			throw new StorableNotFoundException(
					"This username does not match this password.");
	}

		static Logger log = Logger.getLogger(JPAUserActions.class);

}
