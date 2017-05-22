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

/*import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;*/

import com.fdmgroup.entity.Basket;

public class BasketDAO implements IStorage<Basket> {

	private static BasketDAO basketDAO;

	private BasketDAO() {
		super();
	}

	public static BasketDAO getInstance() {
		if (basketDAO == null)
			basketDAO = new BasketDAO();
		return basketDAO;
	}

	public Basket create(Basket newBasket) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "INSERT INTO EC_Basket(basket_id,user_id, item_id, qty) Values(EC_BASKET_ID_SEQ.NEXTVAL,?,?,?)";

			con = DataSource.getInstance().getConnection();
			ps = con.prepareStatement(query);

			ps.setInt(1, newBasket.getUser().getId());
			ps.setInt(2, newBasket.getItem().getId());
			ps.setInt(3, newBasket.getCount());
			ps.executeUpdate();

			return newBasket;
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
	
	public Basket update(Basket basket){
		Connection con = null;
		PreparedStatement ps =null;
		
	try{
			
		String query = "UPDATE ER_BASKET SET qty = ? WHERE basket_id = ?";
		con = DataSource.getInstance().getConnection();
		ps = con.prepareStatement(query);
		
		ps.setInt(1, basket.getCount());
		ps.setInt(2, basket.getId());
		
		ps.executeUpdate();
		
		return basket;
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
	
	public boolean delete(Basket basket){
		Connection con = null;
		PreparedStatement ps =null;
		
		try{
			String query = "DELETE FROM ER_BASKET WHERE Basket_id = ?";
			con = DataSource.getInstance().getConnection();
			ps =  con.prepareStatement(query);
			ps.setInt(1, basket.getId());
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
	
	public List<Basket> findBasketByUserName(String userName) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserDAO userDAO = UserDAO.getInstance();
		ItemDAO itemDAO = ItemDAO.getInstance();
		
		
		try{
			String query = "SELECT * FROM EC_BASKET JOIN EC_USERS ON EC_BASKET.user_id = EC_USERS.user_id JOIN EC_items ON EC_ITEMS.item_id = EC_Basket.item_id WHERE EC_USERS.USER_NAME = ?";
			con = DataSource.getInstance().getConnection();

			ps = con.prepareStatement(query);
			ps.setString(1, userName);
			rs = ps.executeQuery();

			List<Basket> baskets = new ArrayList<Basket>();
			while (rs != null && rs.next()) {
				Basket basket = new Basket();
				
				basket.setId(rs.getInt("basket_id"));
				basket.setUser(userDAO.read(rs.getInt("user_id")));
				basket.setItem(itemDAO.read(rs.getInt("item_id")));
				basket.setCount(rs.getInt("count"));
				baskets.add(basket);
				
		}
		return baskets;
		
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

	@Override
	public Basket read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

	/*
	 * @Autowired
	 * 
	 * @Qualifier("dbConnection") private DBConnection dbConnection;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("itemDAO") private ItemDAO itemDAO;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("userDAO") private UserDAO userDAO;
	 * 
	 * 
	 * public ItemDAO getItemDAO() { return itemDAO; }
	 * 
	 * @Autowired public void setItemDAO(ItemDAO itemDAO) { this.itemDAO =
	 * itemDAO; }
	 * 
	 * public UserDAO getUserDAO() { return userDAO; }
	 * 
	 * @Autowired public void setUserDAO(UserDAO userDAO) { this.userDAO =
	 * userDAO; }
	 * 
	 * 
	 * public DBConnection getDbConnection() { return dbConnection; }
	 * 
	 * public void setDbConnection(DBConnection dbConnection) {
	 * this.dbConnection = dbConnection; }
	 * 
	 * @Override public Basket read(long id) { EntityManager em =
	 * dbConnection.getEntityManager(); return em.find(Basket.class, id); }
	 * 
	 * public Basket update(Basket basket) { EntityManager em =
	 * dbConnection.getEntityManager(); em.getTransaction().begin();
	 * em.merge(basket); em.getTransaction().commit(); return basket; }
	 * 
	 * public boolean delete(Basket t) { EntityManager em =
	 * dbConnection.getEntityManager(); if(em.contains(t)) {
	 * em.getTransaction().begin(); em.remove(t); em.getTransaction().commit();
	 * return true; } return false; }
	 * 
	 * 
	 * public Basket findbasketByUserId(long id){ EntityManager em =
	 * dbConnection.getEntityManager(); Query query =
	 * em.createNamedQuery("basket.findByUserId"); query.setParameter("uId",
	 * id);
	 * 
	 * List<Basket> basket = query.getResultList();
	 * 
	 * if(basket==null || basket.size() > 1) return null;
	 * 
	 * return basket.get(0); }
	 */



