package com.fdmgroup;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uname = request.getParameter("username");
	String password = request.getParameter("password");
	String num1 = request.getParameter("num1");
	String num2 = request.getParameter("num2");
	
	int num1Int = Integer.parseInt(num1) + 15;
	int num2Int = Integer.parseInt(num2) + 25;
	
	
	if(uname.equals("jdoe")&& password.equals("1234")){
		//response.sendRedirect("welcome.html");
		request.setAttribute("num1", num1Int);
		request.setAttribute("num2", num2Int);
		RequestDispatcher rd = request.getRequestDispatcher("/calculator");
		rd.forward(request, response);
	}
	else{
		PrintWriter out = response.getWriter();
		//response.sendRedirect("login.html");
		out.println("<p>Please enter correct password!</p>");

		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.include(request, response);
	}
	}

}
