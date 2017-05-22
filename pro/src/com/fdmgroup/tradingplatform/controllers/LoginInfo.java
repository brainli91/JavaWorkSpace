package com.fdmgroup.tradingplatform.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.PropertyConfigurator;
import org.jboss.logging.Logger;

import com.fdmgroup.tradingplatform.bin.EntityFactory;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.dao.LogRAMDAO;
import com.fdmgroup.tradingplatform.jdbc.PersonJDBC;


/**
 * Servlet implementation class LoginInfo
 */
public class LoginInfo extends HttpServlet {
	
	static Logger log = Logger.getLogger("LoginInfo");	
	
	private LogRAMDAO logRAMDAO = new LogRAMDAO();
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginInfo() {
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
		String password = request.getParameter("password");

		logRAMDAO.setEmf(EntityFactory.getEmf());
		Person person = logRAMDAO.read(username);
		
		if (person == null || !person.getPassword().equals(password)){
			
			String error = "Wrong Username or Password!";
			
			request.setAttribute("error", error);
			log.info("Wrong Username or Password!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Loginfail");
			dispatcher.forward(request, response);
		}
		else if(person.getRoles().size() >= 2)
		{
			HttpSession session=request.getSession();  
			session.setAttribute("person", person);
			log.info("User Login! " + person);
			response.sendRedirect("TwoLogin");	
		}
		else if(person.getRoles().iterator().next().getRoleId() == 1){
			HttpSession session=request.getSession();  
			session.setAttribute("person", person);
			log.info("User Login! " + person);
			response.sendRedirect("ShLogin");	
		}
		else {
			HttpSession session=request.getSession();  
			session.setAttribute("person", person);
			log.info("User Login! " + person);
			response.sendRedirect("AdLogin");	
		}
//		
	}

}
