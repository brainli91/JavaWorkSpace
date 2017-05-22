package userManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import dao.UserDAO;
import dto.Person;
import exceptions.NoUserException;

public class UserActions {

	UserDAO userdao = new UserDAO();

	public Person Login(String username, String password) throws NoUserException {
		
		if (userdao.read(username) == null)
			throw new NoUserException("This user does not exist.");
		
		if (userdao.read(username).getPassword().equals(password)) {
			PropertyConfigurator.configure("log4j.properties");
			log.info(username + " has logged in");
			return userdao.read(username);
		} 
		
		else
			throw new NoUserException(
					"This username does not match this password.");
	}

	static Logger log = Logger.getLogger(UserActions.class);

}
