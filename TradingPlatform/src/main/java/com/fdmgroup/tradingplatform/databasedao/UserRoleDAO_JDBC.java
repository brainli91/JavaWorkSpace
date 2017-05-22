package com.fdmgroup.tradingplatform.databasedao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

public class UserRoleDAO_JDBC {

	public List<Role> readAll() {
		return null;
	}

	public Role create(Role t) {
		return null;
	}

	public List<Integer> read(int userId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String query = "SELECT * FROM tp_user_role WHERE user_id = ? ";
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			
			List<Integer> listRoleIds = new ArrayList<Integer>();

			
			while(rs != null && rs.next()){
				listRoleIds.add(rs.getInt("role_id"));
			}
			return listRoleIds;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Role update(Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Role t) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Role> findRoleByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> findRoleByUserName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Role findRoleByRoleName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
