package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.tradingplatform.databasedao.RoleDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateuser")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
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
		User targetUser = userDAO.findByUserName(username);
		targetUser.setPassWord(password);
		targetUser.setFirstName(firstname);
		targetUser.setLastName(lastname);
		targetUser.setRoles(roles);
		
		
		if (userDAO.findByUserName(username)!=null){
			if(userDAO.update(targetUser)!= null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("showusers");
			dispatcher.forward(request, response);
			return;
			}
		}
		request.setAttribute("usernotexist", "User Does Not Exists!");
		RequestDispatcher rd = request.getRequestDispatcher("updateuser.jsp");
		rd.forward(request, response);

	}
}
