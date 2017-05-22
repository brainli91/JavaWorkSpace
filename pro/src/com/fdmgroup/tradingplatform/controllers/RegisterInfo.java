package com.fdmgroup.tradingplatform.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import com.fdmgroup.tradingplatform.bin.Person;

/**
 * Servlet implementation class RegisterInfo
 */

public class RegisterInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger("RegisterInfo");	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("confirmpassword");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		Person person = new Person();
		person.setPassword(password);
		person.setUserName(username);
		person.setFirstname(firstname);
		person.setLastName(lastname);
		
		request.setAttribute("person", person);
		
		log.info("User Registered! " + person);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Registersuccess");
		dispatcher.forward(request, response);
	}

}
