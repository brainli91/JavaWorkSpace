package dao;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import dto.Person;
import exceptions.NoUserException;

public class UserDAO implements IStorage<Person, String, Integer> {

	/**
	 * DAO data access object.
	 */

	// UserList userList = new UserList();

//	Random rand = new Random();
//	int rand_num = rand.nextInt(9999) + 1;

	  
	static ArrayList<Person> userList = new ArrayList<Person>();
	
	@Override
	public Person create(Person user) {
		PropertyConfigurator.configure("log4j.properties");
		log.info(user + " has been created");
		userList.add(user);
		return user;
	}

	@Override
	public Person read(String username) throws NoUserException{
		
	
		
		for (Person user : userList) {
			if (user.getUsername().equals(username))
				return user;
		}
		throw new NoUserException("User Not found");
//		return null;
	}

	@Override
	public void update(Person user, Person newuser) {
		for (int i = 0; i < userList.size(); i++) {
			if(userList.get(i).equals(user)){
				PropertyConfigurator.configure("log4j.properties");
				log.info(user + " has been updated");
			userList.set(i, newuser);
			}
		}
	}


	@Override
	public void delete(Integer id) throws NoUserException {
		// TODO Auto-generated method stub
		UserDAO userdao = new UserDAO();
		
		
			
		for(int i = 0; i<userList.size()-1; i++){
			if(userList.get(i).getUserID()==id){
				
				userList.remove(i);
				PropertyConfigurator.configure("log4j.properties");
				log.info(userList.get(i).getUsername() + " has been deleted");
			}
		}
		
//		if(userdao.read(id)==null)
//			throw new NoUserException("This user does not exist");
		
		
	}
	static Logger log = Logger.getLogger(UserDAO.class);

}