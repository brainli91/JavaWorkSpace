package com.fdmgroup.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.fdmgroup.entity.IStorable;
import com.fdmgroup.entity.Item;

public class ItemDAO implements IStorable {

	private static ItemDAO itemDAO;

	private ItemDAO() {
		super();
	}

	public static ItemDAO getInstance() {
		if (itemDAO == null)
			itemDAO = new ItemDAO();
		return itemDAO;
	}

	public Item read(int itemId) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM EC_items WHERE item_id = ?";
			con = DataSource.getInstance().getConnection();
			Item item = new Item();

			ps = con.prepareStatement(query);
			ps.setLong(1, itemId);
			rs = ps.executeQuery();

			if (rs != null && rs.next()) {
				item.setId(rs.getInt("item_id"));
				item.setName(rs.getString("item_name"));
				item.setPrice(rs.getDouble("item_price"));
				return item;
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

/*
 * package com.fdmgroup.dao;
 * 
 * import javax.persistence.EntityManager;
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * 
 * import com.fdmgroup.entity.Item;
 * 
 * public class ItemDAO implements IStorage<Item> {
 * 
 * @Autowired private DBConnection dbConnection;
 * 
 * public ItemDAO() { super(); }
 * 
 * public DBConnection getDbConnection() { return dbConnection; }
 * 
 * public void setDbConnection(DBConnection dbConnection) { this.dbConnection =
 * dbConnection; }
 * 
 * @Override public Item read(long id) { EntityManager em =
 * dbConnection.getEntityManager(); Item item = em.find(Item.class, id); return
 * item; }
 * 
 * public Item update(Item item) { EntityManager em =
 * dbConnection.getEntityManager(); em.getTransaction().begin(); em.merge(item);
 * em.getTransaction().commit(); return item; } }
 */