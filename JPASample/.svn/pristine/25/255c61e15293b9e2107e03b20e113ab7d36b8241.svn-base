

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.fdmgroup.model.Company;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.Stock;
import com.fdmgroup.model.User;
import com.fdmgroup.model.UserProfile;

public class MainApp {
		
		public static void main(String[] args) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPASample");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tr = em.getTransaction();
			
			//It is detached if it is not managed in the transaction
//			User user3 = new User(3,"bli","435","Brian","Lee");
			
			tr.begin();
			User user = new User("jdoe","1234","John","Doe", new UserProfile("Toronto, ON","4169689564",25));
			User user2 = new User("asmith","9856","Alex","Smith",new UserProfile("London, ON","35345544",14));
			User user3 = new User("bli","435","Brian","Li",new UserProfile("Toronto, ON","456456456",7));
			
			Role r1 = new Role("Shareholder");
			Role r2 = new Role("Broker");
			
			List<Role> roles1 = new ArrayList<>();
			roles1.add(r1);
			
			List<Role> roles2 = new ArrayList<>();
			roles2.add(r1);
			roles2.add(r2);
			
			List<Role> roles3 = new ArrayList<>();
			roles3.add(r2);
			
			user.setRoles(roles1);
			user2.setRoles(roles2);
			user3.setRoles(roles3);
			
			
			Stock s1= new Stock("GGL");
			Stock s2= new Stock("MS");
			
			Company c1 = new Company("Google", 99.99,s1,"Mountain View,CA", new Date(1998,02,01),150000);
			Company c2 = new Company("Microsoft", 50.25,s2,"Redmond WA", new Date(1980,07,01),200000);
			
			user.setCompany(c1);
			user2.setCompany(c2);
			user3.setCompany(c2);
			
			

			
//			c1.setStock(s1);
//			c2.setStock(s2);

			em.persist(user);
			em.persist(user2);
			em.persist(user3);
			
			
			
//			User foundUser = em.find( User.class, 2);
//			foundUser.setPassword("1236575677");
//			user3 =em.merge(user3);
//			em.remove(user3);
	
			tr.commit();
			System.out.println("Data Stored");
			em.close();
			emf.close();
			
		}

}
