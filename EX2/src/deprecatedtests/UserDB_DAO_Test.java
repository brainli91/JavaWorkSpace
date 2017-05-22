package deprecatedtests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.sql.SQLException;

import jdbc.UserDB_DAO;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dto.Person;
import exceptions.NoUserException;

public class UserDB_DAO_Test {
	
	private UserDB_DAO dao = new UserDB_DAO();
	@Mock Person user1,user2, user3;
	
	@Before
	public void setUp(){
		
		MockitoAnnotations.initMocks(this);
		
		when(user2.getUserID()).thenReturn(20);
		when(user2.getPassword()).thenReturn("secretpassword");
		when(user2.getUsername()).thenReturn("lyang");
		when(user2.getFirstname()).thenReturn("Louis");
		when(user2.getLastname()).thenReturn("Yang");
		when(user2.getRoleID()).thenReturn(2);
		
		when(user3.getPassword()).thenReturn("newpassword");
		when(user3.getUsername()).thenReturn("newlyang");
		when(user3.getFirstname()).thenReturn("newLouis");
		when(user3.getLastname()).thenReturn("newYang");
		when(user3.getRoleID()).thenReturn(1);
	}
	
	@Test
	public void TestReadMethod(){
		try {
			user1=dao.read("JA");
			assertTrue(user1.getFirstname().equals("Jack"));
		} catch (NoUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	(expected=NoUserException.class)
	public void TestReadThrowsException() throws SQLException{
		try{
			dao.read("feafe");
		} catch (NoUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void TestCreateUser(){
//		dao.create(user2);
//	}
	
//	@Test
//	public void TestUpdateUser(){
//		dao.update(user2, user3);
//		
//	}
	
//	@Test
//	(expected=NoUserException.class)
//	public void TestDeleteUser() {
//		try {
//			dao.delete(20);
//			dao.read("newlyang");
//		} catch (NoUserException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
