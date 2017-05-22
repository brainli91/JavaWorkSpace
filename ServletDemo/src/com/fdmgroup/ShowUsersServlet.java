package com.fdmgroup;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.DBConnection;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ShowUsersServlet
 */

@WebServlet("/showusers")

public class ShowUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUsersServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		DBConnection dbConnection = new DBConnection();
		List<User> users = dbConnection.findAllUsers();
		
		out.println("<html>"
				+ "<body>"
		
				+ "<table border ='1'>"
				+"<thead>"
				+"<tr>"
				+ "<td>ID</td>"
				+ "<td>First Name</td>"
				+ "<td>Last Name</td>"
				+ "<td>Username</td>"
				+ "<td>Password</td>"
				+"</tr>"
				+"</thead>"
				+ "<tbody>");
				for (User user : users){
					out.println("<tr>"
							+"<td>" + user.getUserID() +"</td>"
							+"<td>" + user.getFirstname() +"</td>"
							+"<td>" + user.getLastname() +"</td>"
							+"<td>" + user.getUsername() +"</td>"
							+"<td>" + user.getPassword() +"</td>"
							+"</tr>");
				}
				out.println("</tbody>"
				+ "</table>"
				+ "</body>"
				+ "</html>"		);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
