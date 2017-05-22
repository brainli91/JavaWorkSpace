package com.fdmgroup.tradingplatform.databasedao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fdmgroup.tradingplatform.dao.IRoleDAO;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

public class RoleDAO_JDBC implements IRoleDAO {

	private static RoleDAO_JDBC roleDAO;
	
	
	private RoleDAO_JDBC() {
		super();
	}
	
	public static RoleDAO_JDBC getInstance(){
		if (roleDAO == null)
			roleDAO = new RoleDAO_JDBC();
		
		return roleDAO;
	}

	public List<Role> readAll() {
		return null;
	}

	public Role create(Role t) {
		return null;
	}

	public Role read(int roleId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM tp_role WHERE role_id = ?";
			con = DataSource.getInstance().getConnection();
			Role role = new Role();
			ps = con.prepareStatement(query);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();

			if (rs != null && rs.next()) {

				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("role_name"));
				return role;

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

	public Role update(Role t) {
		return null;
	}

	public boolean delete(Role t) {
		return false;
	}

	public List<Role> findRoleByUser(User user) {
		return null;
	}

	public List<Role> findRoleByUserName(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet  rs = null;
		
		String query = "SELECT * FROM tp_users JOIN tp_user_role ON tp_users.user_id =tp_user_ROLE.USER_ID JOIN TP_ROLE ON TP_USER_ROLE.ROLE_ID = TP_ROLE.ROLE_ID where TP_USERS.user_name = ?";
		return null;
	}

	public Role findRoleByRoleName(String roleName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM tp_role WHERE role_name = ?";
			con = DataSource.getInstance().getConnection();
			Role role = new Role();
			ps = con.prepareStatement(query);
			ps.setString(1, roleName);
			rs = ps.executeQuery();

			if (rs != null && rs.next()) {

				role.setId(rs.getInt("role_id"));
				role.setName(rs.getString("role_name"));
				return role;

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
