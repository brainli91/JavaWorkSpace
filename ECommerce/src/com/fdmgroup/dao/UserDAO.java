package com.fdmgroup.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.entity.IStorable;
import com.fdmgroup.entity.User;




public class UserDAO implements IStorage {

	public static UserDAO userDAO;

	private UserDAO() {
		super();
	}

	public static UserDAO getInstance() {
		if (userDAO == null)
			userDAO = new UserDAO();

		return userDAO;
	}

	@Override
	public User read(Integer userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		

		try {

			String query = "SELECT * FROM tp_users WHERE user_id = ?";

			con = DataSource.getInstance().getConnection();
			User user = new User();

			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			if (rs != null && rs.next()) {

				user.setId(rs.getInt("user_id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}

		return null;
	}

	public List<User> readAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM ec_users WHERE user_name NOT LIKE '~%'";
			
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			List<User> users = new ArrayList<User>();

			while (rs != null && rs.next()) {
				
				User user = new User();
				
				user.setId(rs.getInt("user_id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				
				users.add(user);

			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}

		return null;
	}

	public User create(User newUser) {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "INSERT INTO EC_USERS(user_id,pw,user_name, first_name,last_name) Values(EC_USER_ID_SEQ.NEXTVAL,?,?,?,?)";

			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, newUser.getPassword());
			ps.setString(2, newUser.getUsername());
			ps.setString(3, newUser.getFirstName());
			ps.setString(4, newUser.getLastName());
			ps.executeUpdate();



			return findByUserName(newUser.getUsername());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, null);
		}

		return null;
	}


	
	
	
	
	public User findByUserName(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM ec_users where ec_USERS.user_name = ?";

			con = DataSource.getInstance().getConnection();
			User user = new User();

			ps = con.prepareStatement(query);
			ps.setString(1, userName);

			rs = ps.executeQuery();

			if (rs != null && rs.next()) {
				
				user.setId(rs.getInt("user_id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}
		return null;
	}

	private static void closeAll(Connection cn, Statement st, ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (cn != null)
				cn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}






}


/*package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.entity.Basket;
import com.fdmgroup.entity.User;

public class UserDAO implements IStorage<User> {

	@Autowired
	private DBConnection dbConnection;

	public UserDAO() {
		super();
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public User read(long id) {
		EntityManager em = dbConnection.getEntityManager();
		return em.find(User.class, id);
	}

	public User create(User user) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return user;
	}
	
	
	public User findByUsername(String username){
	    EntityManager em = dbConnection.getEntityManager();
	    Query query = em.createNamedQuery("user.findByUsername");
	    query.setParameter("username", username);
	    List<User> users = query.getResultList();
	    if (users == null || users.size() != 1) {
	      return null;
	    }
	    return users.get(0);
	}
}
*/



