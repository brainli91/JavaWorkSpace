package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = UserDAO_JDBC.getInstance().findByUserName(username);
		List<String> roles = UserDAO_JDBC.getInstance().findRoleByUserName(username);
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		
		if (userDAO.findByUserName(username)==null){
			
			request.setAttribute("loginfailure", "Please Enter Correct Username/Password!");
			RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
			rd.forward(request, response);
			return;
		}
		
		if(user!= null){
			if(user.getPassWord().equals(password)){
				Logger logger = Logger.getLogger("sysLogger");
				logger.info("Login sucessfully --> "+ username);
				HttpSession session =request.getSession();
				session.setAttribute("user", user);
				session.setMaxInactiveInterval(300);
				
				
					if(roles.contains("broker")&&roles.contains("shareholder"))
					{
						//Broker and shareholder page
						return;
					}
					if(roles.contains("admin")){
						RequestDispatcher rd = request.getRequestDispatcher("adminindex.jsp");
						rd.forward(request, response);
						return; 
					}
					if(roles.contains("shareholder")){
						RequestDispatcher rd = request.getRequestDispatcher("shareholderindex.jsp");
						rd.forward(request, response);
						return; 
					}
					
					if(roles.contains("broker")){
						RequestDispatcher rd = request.getRequestDispatcher("brokerindex.jsp");
						rd.forward(request, response);
						return; 
					}
					
				
				
			}
		}
		Logger logger = Logger.getLogger("sysLogger");
		logger.info("Login not sucessfully --> "+ username);
		request.setAttribute("loginfailure", "Please Enter Correct Password!");
		RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
		rd.forward(request, response);
	}

}
