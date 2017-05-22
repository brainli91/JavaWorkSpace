package com.fdmgroup.tradingplatform.databasedao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import com.fdmgroup.tradingplatform.dao.ITradeDAO;
import com.fdmgroup.tradingplatform.model.Trade;
import com.fdmgroup.tradingplatform.model.User;

public class TradeDAO_JDBC implements ITradeDAO {

	private static TradeDAO_JDBC tradeDAO;

	private TradeDAO_JDBC() {
		super();
	}

	public static TradeDAO_JDBC getInstance() {
		if (tradeDAO == null)
			tradeDAO = new TradeDAO_JDBC();
		return tradeDAO;
	}

	public List<Trade> readAll() {
		return null;
	}

	public Trade create(Trade t) {
		return null;
	}

	public Trade read(int tradeId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();
		RequestDAO_JDBC requestDAO = RequestDAO_JDBC.getInstance();

		String query = "SELECT * FROM tp_trade WHERE trade_id = ?";

		try {
			con = DataSource.getInstance().getConnection();
			Trade trade = new Trade();

			ps = con.prepareStatement(query);
			ps.setInt(1, tradeId);
			rs = ps.executeQuery();

			if (rs != null && rs.next()) {

				trade.setId(rs.getInt("trade_id"));
				trade.setCompany(companyDAO.read(rs.getInt("stock_id")));
				trade.setTransactionTime(rs.getDate("transaction_time"));
				trade.setShares(rs.getInt("shares"));
				trade.setSharePrice(rs.getDouble("share_price"));
				trade.setPriceTotal(rs.getDouble("price_total"));
				trade.setBuyer(userDAO.read(rs.getInt("buyer_id")));
				trade.setSeller(userDAO.read(rs.getInt("seller_id")));
				trade.setBuyRequest(requestDAO.read(rs.getInt("buy_request_id")));
				trade.setSellRequest(requestDAO.read(rs.getInt("sell_request_id")));
				return trade;

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

	public Trade update(Trade t) {
		return null;
	}

	public boolean delete(Trade t) {
		return false;
	}

	public List<Trade> findTradeByUserName(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();
		RequestDAO_JDBC requestDAO = RequestDAO_JDBC.getInstance();

		try {
			String query = "SELECT * FROM tp_trade tr JOIN tp_users b ON tr.buyer_id = b.user_id JOIN tp_users s ON tr.seller_id = s.user_id WHERE b.user_name =? OR s.user_name =?";
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, userName);
			rs = ps.executeQuery();

			List<Trade> trades = new ArrayList<Trade>();

			while (rs != null && rs.next()) {
				Trade trade = new Trade();
				trade.setId(rs.getInt("trade_id"));
				trade.setCompany(companyDAO.read(rs.getInt("stock_id")));
				trade.setTransactionTime(rs.getDate("transaction_time"));
				trade.setShares(rs.getInt("shares"));
				trade.setSharePrice(rs.getDouble("share_price"));
				trade.setPriceTotal(rs.getDouble("price_total"));
				trade.setBuyer(userDAO.read(rs.getInt("buyer_id")));
				trade.setSeller(userDAO.read(rs.getInt("seller_id")));
				trade.setBuyRequest(requestDAO.read(rs.getInt("buy_request_id")));
				trade.setSellRequest(requestDAO.read(rs.getInt("sell_request_id")));
				trades.add(trade);

			}
			return trades;
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
	
	public HashMap<Integer, Integer> portfolioForUser(String userName){

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();
		RequestDAO_JDBC requestDAO = RequestDAO_JDBC.getInstance();
		
		try {
			String query ="SELECT tr.*,b.user_name AS \"buyername\", s.user_name AS \"sellname\" FROM tp_trade tr JOIN tp_users b ON tr.buyer_id = b.user_id JOIN tp_users s ON tr.seller_id = s.user_id JOIN tp_company co ON tr.stock_id = co.stock_id WHERE b.user_name =? OR s.user_name=? ";
			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, userName);

			rs = ps.executeQuery();
			HashMap<Integer, Integer> portfolio = new HashMap<Integer, Integer>();
			while (rs != null && rs.next()) {
				if (rs.getString("buyername").equals(userName)){
					if(portfolio.containsKey(rs.getInt("stock_id"))){
						Integer shares = portfolio.get(rs.getInt("stock_id")) + rs.getInt("shares");
						portfolio.put(rs.getInt("stock_id"), shares);
					}
					else{
						portfolio.put(rs.getInt("stock_id"), rs.getInt("shares"));
					}
				}
				else if (rs.getString("sellername").equals(userName)){
					if(portfolio.containsKey(rs.getInt("stock_id"))){
						Integer shares = portfolio.get(rs.getInt("stock_id")) - rs.getInt("shares");
						portfolio.put(rs.getInt("stock_id"), shares);
					}

				}

				

			}
			return portfolio;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}finally {
			closeAll(con,ps,rs);
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
