import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.model.Company;
import com.fdmgroup.model.Profile;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.Stock;
import com.fdmgroup.model.User;

public class MainApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("JPAExample");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tr = em.getTransaction();
/*		tr.begin();

		User user1 = new User("jdoe", "123456",new Profile("John","Doe","Toronto,ON"));
		User user2 = new User("asmith", "98765",new Profile("Ash","Smith","London,ON"));
		User user3 = new User("dbowie", "5678345",new Profile("Dow","Boie","Oshwa,ON"));

		Role r1 = new Role("Admin");
		Role r2 = new Role("Broker");
		Role r3 = new Role("Shareholder");
		
		Calendar cal = Calendar.getInstance();
		cal.set(1998,Calendar.JANUARY,1);
		Company c1 = new Company("Google","Mountain View, CA",cal.getTime(),150000, new Stock("GGL"));
		

		cal.set(1980,Calendar.JULY,20);
		Company c2 = new Company("Microsoft","Redmond, MA",cal.getTime(),10000, new Stock("MS"));
		
		Set<Role> roles1 = new HashSet<Role>();
		roles1.add(r1);
		
		Set<Role> roles2 = new HashSet<Role>();
		roles2.add(r2);
		roles2.add(r3);
		
		Set<Role> roles3 = new HashSet<Role>();
		roles3.add(r3);
		
		user1.setRoles(roles1);
		user2.setRoles(roles2);
		user3.setRoles(roles3);
		
		user1.setCompany(c1);
		user2.setCompany(c2);
		user3.setCompany(c1);

		em.persist(user1);
		em.persist(user2);
		em.persist(user3);
		
	
		em.persist(r1); em.persist(r2); em.persist(r3);
	
		
		tr.commit();
		
		System.out.println("Objects Stored.");*/
		
		User user = em.find(User.class, 1462298323466L);
		System.out.println(user);
		System.out.println("**********************************");
		
		Query query = em.createNamedQuery("user.findAll");
		List<User> users = query.getResultList();
		for(User u :users){
			System.out.println(u);
		}
		
		System.out.println("*****************************************");
		
		query = em.createNamedQuery("user.findByUsername");
		query.setParameter("uname", "jdoe");
		//If the list contains more than 1 or null will give NoResultException
		User u = (User) query.getSingleResult();
		System.out.println(u);
		
		System.out.println("*****************************************");
		
		Calendar cal = Calendar.getInstance();
		query = em.createNamedQuery("company.findByEstalished");
		cal.set(1985, Calendar.JANUARY,1);
		query.setParameter("fromDate", cal.getTime());
		cal.set(2000, Calendar.SEPTEMBER,1);
		query.setParameter("toDate", cal.getTime());
		List<Company> companies = query.getResultList();
		
		em.getTransaction().begin();
		
		for(Company c :companies){
			c.setNumberOfEmployee(3000000);
			//em.merge(c);
			em.remove(c);
			System.out.println(c);
			Set<User> usersOfTheCompany = c.getUsers();
			for (User us : usersOfTheCompany){
				System.out.println(us);
			}
		}
		
		em.getTransaction().commit();
		//entity manager handle all entities
		em.close();
		//only close once during your application since is costly
		emf.close();
	}
}
