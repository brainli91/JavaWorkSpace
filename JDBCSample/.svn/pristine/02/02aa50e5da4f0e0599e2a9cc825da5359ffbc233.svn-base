package com.fdmgroup;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCApp {
	public static void main(String[] args) {
		// testStatement();
		// testPS();
		// testCS();
		// testCS2();
		// testPS2();
		// write join
		testPS3();
	}

	private static void testPS3() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM tp_users JOIN tp_user_role ON tp_users.user_id =tp_user_ROLE.USER_ID JOIN TP_ROLE ON TP_USER_ROLE.ROLE_ID = TP_ROLE.ROLE_ID where TP_USERS.FIRST_NAME LIKE ?";
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "trainee1",
					"!QAZSE4");
			ps = con.prepareStatement(query);
			ps.setString(1, "J%");
			rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				int id = rs.getInt("user_id");

				List<String> roles = getRole(con, ps, id);

				String pw = rs.getString("pw");
				String uname = rs.getString("user_name");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String role = rs.getString("role_name");

				System.out.println(id + ")" + fname + " " + lname + "---->"
						+ uname + "," + pw + "Roles: " + role);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}

	}

	private static void testPS2() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM TP_USERS WHERE FIRST_NAME LIKE?";
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "trainee1",
					"!QAZSE4");
			ps = con.prepareStatement(query);
			ps.setString(1, "J%");
			rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				int id = rs.getInt("user_id");

				List<String> roles = getRole(con, ps, id);

				String pw = rs.getString("pw");
				String uname = rs.getString("user_name");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");

				System.out.println(id + ")" + fname + " " + lname + "---->"
						+ uname + "," + pw + "Roles: " + roles);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}

	}

	private static List<String> getRole(Connection con, PreparedStatement ps,
			int id) {
		List<String> roles = new ArrayList<String>();
		ResultSet rs = null;
		String query = "SELECT * FROM TP_USER_ROLE WHERE USER_ID = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs != null & rs.next()) {
				int roleId = rs.getInt("ROLE_ID");
				String roleName = getRoleName(con, ps, roleId);
				roles.add(roleName);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, null, rs);
		}
		return roles;
	}

	private static String getRoleName(Connection con, PreparedStatement ps,
			int roleId) {
		ResultSet rs = null;
		String query = "SELECT * FROM TP_ROLE WHERE ROLE_ID = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();

			if (rs != null & rs.next()) {
				String roleName = rs.getString("ROLE_NAME");

				return roleName;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, ps, rs);
		}
		return null;
	}

	private static void testCS2() {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {

			String query = "{call findUserByFirstName(?, ?)}";
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "trainee1",
					"!QAZSE4");
			cs = con.prepareCall(query);
			cs.setString(1, "%J");
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);

			cs.execute();
			rs = (ResultSet) cs.getObject(2);

			while (rs != null && rs.next()) {
				int id = rs.getInt("user_id");
				String pw = rs.getString("pw");
				String uname = rs.getString("user_name");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				System.out.println(id + ") " + fname + " " + lname + " --->"
						+ uname + ", " + pw);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, cs, rs);
		}

	}

	private static void testCS() {
		Connection con = null;
		CallableStatement cs = null;
		ResultSet rs = null;

		try {

			String query = "{call getUserNameById(?, ?)}";
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "trainee1",
					"!QAZSE4");
			cs = con.prepareCall(query);
			cs.setInt(1, 22);
			cs.registerOutParameter(2, oracle.jdbc.OracleTypes.VARCHAR);

			cs.execute();
			String uname = cs.getString(2);

			System.out.println("22) " + uname);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(con, cs, rs);
		}

	}

	private static void testPS() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "INSERT INTO TBL_USER(userid, username,password) Values(?,?,?)";
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "trainee1",
					"!QAZSE4");
			ps = con.prepareStatement(query);

			con.setAutoCommit(false);

			ps.setInt(1, 5);
			ps.setString(2, "yulai");
			ps.setString(3, "54464687");
			ps.addBatch();

			ps.setInt(1, 6);
			ps.setString(2, "sammyb");
			ps.setString(3, "654657");
			ps.addBatch();

			ps.setInt(1, 7);
			ps.setString(2, "omarzhar");
			ps.setString(3, "9846531");
			ps.addBatch();

			int[] rows = ps.executeBatch();

			con.commit();

			// Parameter for executeUpdate
			// ps.executeUpdate();
			// int rows = ps.executeUpdate();

			System.out.println("Rows affected: " + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(con, ps, rs);
		}

	}

	private static void testStatement() {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			// String query
			// ="CREATE TABLE TBL_USER(userId NUMBER(6) PRIMARY KEY, username VARCHAR2(50) NOT NULL, password VARCHAR(50) NOT NULL)";
			// String query
			// ="INSERT INTO TBL_USER(userId, username, password) VALUES(3,'george','234325')";
			// String query =
			// "UPDATE TBL_USER SET password = 69874 WHERE userid =1";
			String query = "SELECT * FROM TBL_USER";
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "trainee1",
					"!QAZSE4");
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			boolean val = st.execute(query);
			int rows = st.executeUpdate(query);
			rs = st.executeQuery(query);

			DatabaseMetaData md = con.getMetaData();
			System.out.println(md.getDatabaseMajorVersion());
			System.out.println(md.getDriverMajorVersion());
			System.out.println(md.getTableTypes());
			System.out.println(md.getSchemas());

			// System.out.println("Rows affected: " +rows);
			while (rs != null && rs.next()) {
				int id = rs.getInt(1);
				String uname = rs.getString("username");
				String password = rs.getString(3);

				System.out.println(id + ")" + uname + "," + password);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			// closeAll(con,st,null);
			closeAll(con, st, rs);

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
