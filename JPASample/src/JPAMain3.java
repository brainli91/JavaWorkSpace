import java.util.List;

import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.User;

public class JPAMain3 {
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		List<User> users = userDAO.findAll();
		for(User user:users)
		System.out.println(user);
		
		System.out.println("______________________________");
		
		User foundUser = userDAO.findByUsername("jdoe");
		System.out.println(foundUser);
	}
}
