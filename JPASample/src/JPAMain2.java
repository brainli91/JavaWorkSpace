import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fdmgroup.model.Company;
import com.fdmgroup.model.User;

public class JPAMain2 {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPASample");
		EntityManager em = emf.createEntityManager();
		
		Company foundCompany = em.find(Company.class, 2);
		System.out.println(foundCompany);
		List<User> users = foundCompany.getUsers();
		
		System.out.println("-----------------------------------");
		for(User user:users){
			System.out.println(user);
		}
		
		System.out.println("-----------------------------------");
		Query query = em.createNamedQuery("user.findByUsername");
		query.setParameter("uname", "jdoe");
		List<User> userList = query.getResultList();
		
		if(userList != null&& userList.size()==1)
		{
			System.out.println(userList.get(0));
		}
//		Object user = query.getSingleResult();
//		System.out.println(user);
		System.out.println("-----------------------------------");
		Query query2=em.createNamedQuery("user.findAll");
		List<User> userList2 = query2.getResultList();
		
		for(User u: userList2){
			System.out.println(u + "--->" + u.getCompany() +"----->" + u.getRoles());
		}
		
		System.out.println("**-----------------------------------**");
		Query query3 = em.createNamedQuery("company.findByDate");
		query3.setParameter("fromDate", new Date(1975,01,01));
		query3.setParameter("toDate", new Date(1990,01,01));
		
		List<Company> companies = query3.getResultList();

		for(Company company: companies){
			System.out.println(company);
		}
		
		em.close();
		emf.close();
	}
}
