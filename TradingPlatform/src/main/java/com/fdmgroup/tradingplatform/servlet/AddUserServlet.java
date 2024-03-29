package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.tradingplatform.databasedao.RoleDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String isAdmin = request.getParameter("administrator");
		String isShare = request.getParameter("shareholder");
		String isBroker = request.getParameter("broker");
		
		List<Role> roles = new ArrayList<Role>();


		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		RoleDAO_JDBC role = RoleDAO_JDBC.getInstance();
		
		
		if(isAdmin!=null){
			roles.add(role.findRoleByRoleName("admin"));
		}
		if(isShare!=null){
			roles.add(role.findRoleByRoleName("shareholder"));
		}
		if(isBroker!=null){
			roles.add(role.findRoleByRoleName("broker"));
		}
		

		if (userDAO.findByUserName(username)!=null){
			request.setAttribute("userexistmsg", "User Name Already Exists!");
			RequestDispatcher rd = request.getRequestDispatcher("adduser.jsp");
			rd.forward(request, response);
		}
		User user = new User();
		user.setUserName(username);
		user.setPassWord(password);
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setRoles(roles);
		
		userDAO.create(user);
		

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminindex.jsp");
		dispatcher.forward(request, response);
	}

}
