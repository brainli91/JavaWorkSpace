package com.fdmgroup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.fdmgroup.model.User;

public class DBConnection {
	
	private Connection getConnection(){
		InitialContext context = null;
		Connection con = null;
		
		try {
			context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/sdcp");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(context != null)
				try {
					context.close();
				} catch (NamingException e) {
					e.printStackTrace();
				}
		}
		return con;
	}
	
	public List<User> findAllUsers(){
		ArrayList<User> users = new ArrayList<>();
		String query ="SELECT * FROM TP_USERS";
		Connection con = getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			if(con!= null){
				
				st = con.createStatement();
				rs = st.executeQuery(query);
				
				while(rs.next()){
					User user = new User();
					user.setUserID(rs.getInt("user_id"));
					user.setUsername(rs.getString("user_name"));
					user.setPassword(rs.getString("pw"));
					user.setFirstname(rs.getString("first_name"));
					user.setLastname(rs.getString("last_name"));
					
					users.add(user);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			closeAll(con,st,rs);
		}
		return users;
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
