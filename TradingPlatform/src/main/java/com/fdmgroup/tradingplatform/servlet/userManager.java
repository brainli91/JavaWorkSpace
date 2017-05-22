package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.User;

/**
 * Servlet implementation class userManager
 */
@WebServlet("/userManager")
public class userManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userManager() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String opt = request.getParameter("operation");
		
		User user = UserDAO_JDBC.getInstance().read(id);
		
		if(user!= null && opt.equals("delete")){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			UserDAO_JDBC.getInstance().delete(user);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/showusers");
			rd.forward(request, response);
			return;
			
		}
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
