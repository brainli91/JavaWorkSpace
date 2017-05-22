package com.fdmgroup.tradingplatform.databasedao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.fdmgroup.tradingplatform.dao.IUserDAO;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

public class UserDAO_JDBC implements IUserDAO {

	public static UserDAO_JDBC userDAO;

	private UserDAO_JDBC() {
		super();
	}

	public static UserDAO_JDBC getInstance() {
		if (userDAO == null)
			userDAO = new UserDAO_JDBC();

		return userDAO;
	}

	public List<User> readAll() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		RoleDAO_JDBC roleDAO = RoleDAO_JDBC.getInstance();

		try {
			String query = "SELECT * FROM tp_users WHERE user_name NOT LIKE '~%'";
			
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			List<User> users = new ArrayList<User>();

			while (rs != null && rs.next()) {
				
				User user = new User();
				
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassWord(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				
				user.setRoles(roleDAO.findRoleByUserName(user.getUserName()));
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
			String query = "INSERT INTO TP_USERS(user_id,pw,user_name, first_name,last_name) Values(TP_USER_ID_SEQ.NEXTVAL,?,?,?,?)";
			String query2 = "INSERT INTO TP_USER_ROLE (user_id, role_id) Values (TP_USER_ID_SEQ.CURRVAL,?)";

			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, newUser.getPassWord());
			ps.setString(2, newUser.getUserName());
			ps.setString(3, newUser.getFirstName());
			ps.setString(4, newUser.getLastName());
			ps.executeUpdate();

			ps = con.prepareStatement(query2);

			List<Role> roles = newUser.getRoles();
			for (Role role : roles) {
				ps.setInt(1, role.getId());
				ps.executeUpdate();
			}
			

			return findByUserName(newUser.getUserName());
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

	public User read(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		RoleDAO_JDBC roleDAO = RoleDAO_JDBC.getInstance();
		

		try {

			String query = "SELECT * FROM tp_users WHERE user_id = ?";

			con = DataSource.getInstance().getConnection();
			User user = new User();

			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();

			if (rs != null && rs.next()) {

				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassWord(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));

				user.setRoles(roleDAO.findRoleByUserName(user.getUserName()));
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

	public User update(User user) {
		Connection con = null;
		PreparedStatement ps = null;


		try {
			String query = "UPDATE tp_users SET pw = ?, first_name = ?,last_name =? WHERE user_id = ?";
			String query2 = "DELETE FROM tp_user_role WHERE user_id = ?";
			String query3 = "INSERT INTO tp_user_role (user_id, role_id) Values (?,?) ";

			con = DataSource.getInstance().getConnection();

			ps = con.prepareStatement(query);

			ps.setString(1, user.getPassWord());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
			

			ps = con.prepareStatement(query2);
			
			ps.setInt(1, user.getId());
			ps.executeUpdate();
			
			ps =  con.prepareStatement(query3);
			List<Role> roles = user.getRoles();
			for (Role role : roles) {

				ps.setInt(1, user.getId());
				ps.setInt(2, role.getId());
				ps.executeUpdate();

			}
			
			
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps, null);
		}

		return null;
	}

	public boolean delete(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		

		
		try {
			String query = "UPDATE tp_users SET user_name = ? WHERE user_name = ?";
			con = DataSource.getInstance().getConnection();
			ps =  con.prepareStatement(query);
			String deleteUser ="~" + user.getUserName();
			ps.setString(1, deleteUser);
			ps.setString(2, user.getUserName());
			if(ps.executeUpdate() == 1)
				return true;
			return false;

			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps, null);
		}
		
		return false;
	}
	
	public List<String> findRoleByUserName (String userName){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String query = "SELECT * FROM tp_users JOIN tp_user_role ON tp_users.user_id =tp_user_ROLE.USER_ID JOIN TP_ROLE ON TP_USER_ROLE.ROLE_ID = TP_ROLE.ROLE_ID where TP_USERS.user_name = ?";

			con = DataSource.getInstance().getConnection();
			User user = new User();

			ps = con.prepareStatement(query);
			ps.setString(1, userName);

			rs = ps.executeQuery();

			if (rs != null && rs.next()) {
				List<String> rolenames = new ArrayList<String>();
				

				rolenames.add( rs.getString("role_name"));
				while (rs != null && rs.next()) {
					rolenames.add(rs.getString("role_name"));
				}

				return rolenames;
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
	
	public User findByUserName(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM tp_users JOIN tp_user_role ON tp_users.user_id =tp_user_ROLE.USER_ID JOIN TP_ROLE ON TP_USER_ROLE.ROLE_ID = TP_ROLE.ROLE_ID where TP_USERS.user_name = ?";

			con = DataSource.getInstance().getConnection();
			User user = new User();

			ps = con.prepareStatement(query);
			ps.setString(1, userName);

			rs = ps.executeQuery();

			if (rs != null && rs.next()) {
				List<Role> roles = new ArrayList<Role>();
				user.setId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassWord(rs.getString("pw"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));

				roles.add(new Role(rs.getInt("role_id"), rs
						.getString("role_name")));
				while (rs != null && rs.next()) {
					roles.add(new Role(rs.getInt("role_id"), rs
							.getString("role_name")));
				}
				user.setRoles(roles);
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
