package deprecatedtests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dao.UserDAO;
import dto.Person;
import exceptions.NoUserException;


public class UserDAOTest {
	
	@Mock Person user1, user2, user3;
	UserDAO userdao = new UserDAO();

	
	@Before
	public void setUp(){
	
		
		MockitoAnnotations.initMocks(this);
		
		userdao.create(user1);
		when(user1.getUsername()).thenReturn("Zvi");
		when(user1.getPassword()).thenReturn("p1");
		when(user1.getUserID()).thenReturn(1);
		
		when(user2.getUsername()).thenReturn("antonio");
		when(user2.getPassword()).thenReturn("p2");
		
		
	}
	
	@Test
	public void TestReadUser() throws NoUserException{
//		userdao.create(user1);
		Person newuser = userdao.read("Zvi");
//		assertTrue(newuser.equals(user1));
		assertEquals(newuser, user1);
	}
	
//	@Test
//	public void TestCreateUserWorks() throws NoUserException{
//		userdao.create(user2);
//		assertNull(userdao.read("antonio")==user2);
//	}
	
	
	
	@Test
	public void TestUpdateUser() throws NoUserException{
//		userdao.create(user1);
		userdao.update(user1, user2);
		assertTrue(userdao.read("antonio").equals(user2));
	}
	
	@Test 
	(expected=NoUserException.class)
	public void TestDeleteUser() throws NoUserException{
		userdao.create(user1);
		userdao.delete(1);
		assertNull(user1);
	}
	

}
