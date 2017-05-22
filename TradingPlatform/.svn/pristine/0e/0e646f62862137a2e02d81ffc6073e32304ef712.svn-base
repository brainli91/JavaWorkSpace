package com.fdmgroup.tradingplatform.databasedao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.tradingplatform.dao.IRequestDAO;
import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.User;

public class RequestDAO_JDBC implements IRequestDAO {

	private static RequestDAO_JDBC requestDAO;

	private RequestDAO_JDBC() {
		super();
	}

	public static RequestDAO_JDBC getInstance() {
		if (requestDAO == null)
			requestDAO = new RequestDAO_JDBC();
		return requestDAO;
	}

	public List<Request> readAll() {
		return null;
	}

	public Request create(Request newRequest) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "INSERT INTO tp_request(request_id, shareholder_id, request_date, buy_sell, status, stock_id, shares, minimum_shares, time_in_force) Values(TP_REQUEST_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";

			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);

			ps.setInt(1, newRequest.getShareholder().getId());
			ps.setDate(2, newRequest.getRequestDate());
			ps.setString(3, newRequest.getType());
			ps.setString(4, newRequest.getStatus());
			ps.setInt(5, (newRequest.getCompany().getId()));
			ps.setInt(6, newRequest.getShareCount());
			ps.setInt(7, newRequest.getMinShares());
			ps.setString(8, newRequest.getTimeInForce());
			ps.executeUpdate();

			return newRequest;
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

	public Request read(int requestId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();

		try {
			String query = "SELECT * FROM tp_request WHERE request_id = ?";
			con = DataSource.getInstance().getConnection();
			Request request = new Request();

			ps = con.prepareStatement(query);
			ps.setInt(1, requestId);
			rs = ps.executeQuery();
			if (rs != null && rs.next()) {

				request.setId(rs.getInt("request_id"));
				request.setShareholder(userDAO.read(rs.getInt("shareholder_id")));
				request.setRequestDate(rs.getDate("request_date"));
				request.setType(rs.getString("buy_sell"));
				request.setStatus(rs.getString("status"));
				request.setCompany(companyDAO.findByStockId(rs.getInt("stock_id")));
				request.setShareCount(rs.getInt("shares"));
				request.setMinShares(rs.getInt("minimum_shares"));
				request.setTimeInForce(rs.getString("time_in_force"));
				return request;
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

	public Request update(Request request) {
		Connection con = null;
		PreparedStatement ps =null;
		
		try {
			String query = "UPDATE tp_request SET shareholder_id = ?, request_dates=?, buy_sell =?, status =?,stock_id = ?,shares= ?,minimum_shares = ?, time_in_force =? WHERE request_id = ?";
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, request.getShareholder().getId());
			ps.setDate(2, request.getRequestDate());
			ps.setString(3, request.getType());
			ps.setString(4, request.getStatus());
			ps.setInt(5, request.getCompany().getStockId());
			ps.setInt(6, request.getShareCount());
			ps.setInt(7, request.getMinShares());
			ps.setString(8, request.getTimeInForce());
			
			ps.setInt(9, request.getId());
			ps.executeUpdate();
			
			return request;
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

	public boolean delete(Request request) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			String query = "DELETE FROM tp_request WHERE request_id = ?";
			con = DataSource.getInstance().getConnection();
			ps =  con.prepareStatement(query);
			ps.setInt(1, request.getId());
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

	public List<Request> findRequestByDate(Date date, User selectedUser) {
		return null;
	}

	public List<Request> findRequestByStatus(String status, User selectedUser) {
		return null;
	}

	public List<Request> findRequestByUserName(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();

		try {
			String query = "SELECT * FROM tp_request JOIN tp_users ON tp_request.shareholder_id = tp_users.user_id JOIN tp_company ON tp_request.stock_id = tp_company.stock_id WHERE TP_USERS.USER_NAME = ?";
			con = DataSource.getInstance().getConnection();

			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			rs = ps.executeQuery();

			List<Request> requests = new ArrayList<Request>();

			while (rs != null && rs.next()) {
				Request request = new Request();

				request.setId(rs.getInt("request_id"));
				request.setShareholder(userDAO.read(rs.getInt("shareholder_id")));
				request.setRequestDate(rs.getDate("request_date"));
				request.setType(rs.getString("buy_sell"));
				request.setStatus(rs.getString("status"));
				request.setCompany(companyDAO.findByStockId(rs.getInt("stock_id")));
				request.setShareCount(rs.getInt("shares"));
				request.setMinShares(rs.getInt("minimum_shares"));
				request.setTimeInForce(rs.getString("time_in_force"));
				requests.add(request);
			}
			return requests;

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally{
			closeAll(con, ps, rs);
		}

		return null;
	}
	public void processRequest(){
		Connection con = null;
		CallableStatement cs = null;
		
		try {
			con = DataSource.getInstance().getConnection();
			String query = "{call TP_REQUEST_PKG.processrequests}";
			cs = con.prepareCall(query);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, cs, null);
		}
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
