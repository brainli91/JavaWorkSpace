package jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import dao.IStorage;
import dto.IStorable;
import dto.Person;
import exceptions.NoUserException;

public class UserDB_DAO extends SuperDAO implements IStorage<Person, String, Integer>{
	
	@Override
	public Person create(Person newuser) {
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url,username,password);
			
			
			String query = "INSERT INTO PERSON (person_id, password, user_name, first_name, last_name) values (?,?,?,?,?)";
			String query2 = "INSERT INTO USER_ROLE (ur_person_id, ur_role_id) values (?,?)";
			
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setInt(1, newuser.getUserID());
			statement.setString(2, newuser.getPassword());
			statement.setString(3, newuser.getUsername());
			statement.setString(4, newuser.getFirstname());
			statement.setString(5, newuser.getLastname());
			
			PreparedStatement statement2 = conn.prepareStatement(query2);
			
			statement2.setInt(1, newuser.getUserID());
			statement2.setInt(2, newuser.getRoleID());
			
			statement.execute();
			statement2.execute();
			
			return newuser;
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally 
		{		   
			// Close the connection
		    if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public Person read(String userName) throws NoUserException {
		
		if(userName.equals(null))
			throw new NoUserException("This user does not exist");
		
		try 
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url,username,password);
			
			Person user = new Person();
					
			String query = getQuery("readUser");
//			System.out.println("query: "+query);
			
			PreparedStatement statement = conn.prepareStatement(query);
	        statement.setString(1, userName);

			ResultSet rs = statement.executeQuery();
			
			if(rs.next()){
			
			user.setFirstname(rs.getString("FIRST_NAME"));
			user.setLastname(rs.getString("LAST_NAME"));
			user.setUserID(rs.getInt("PERSON_ID"));
			user.setPassword(rs.getString("PASSWORD"));
			user.setRoleID(rs.getInt("ROLE_ID"));
			}
			else{
				throw new NoUserException("User not found");
			}

			return user;
	       
	      }
		catch (SQLException sqle) 
		{
			sqle.printStackTrace(); 
			
		} 
		finally 
		{		   
			// Close the connection
		    if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public void update(Person olduser, Person newuser) {
		// TODO Auto-generated method stub
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url,username,password);
			
			CallableStatement cs = conn.prepareCall("{call updateUser(?,?,?,?,?,?)}");
			
			cs.setInt(1, olduser.getUserID());
			cs.setString(2, newuser.getPassword());
			cs.setString(3, newuser.getUsername());
			cs.setString(4, newuser.getFirstname());
			cs.setString(5, newuser.getLastname());
			cs.setInt(6, newuser.getRoleID());
			
			cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{		   
			// Close the connection
		    if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	@Override
	public void delete(Integer id) throws NoUserException {
		// TODO Auto-generated method stub
		
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(url,username,password);
			
			CallableStatement cs = conn.prepareCall("{call deleteUser(?)}");
			
			cs.setInt(1, id);
			
			cs.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{		   
			// Close the connection
		    if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
	
//	public static void main(String[] args) throws NoUserException {
//		UserDB_DAO demo = new UserDB_DAO();
//		UserDTO janet = demo.read("JA");
//		System.out.println(janet.getFirstname());
//		System.out.println(janet.getLastname());
//		System.out.println(janet.getUserID());
//		System.out.println(janet.getRoleID());
//	}

}
