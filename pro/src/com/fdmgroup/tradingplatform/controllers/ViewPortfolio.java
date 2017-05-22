package com.fdmgroup.tradingplatform.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.jboss.logging.Logger;

import com.fdmgroup.tradingplatform.bin.CurrentShareholderShares;
import com.fdmgroup.tradingplatform.bin.EntityFactory;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Portfolio;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.Role;
import com.fdmgroup.tradingplatform.bin.RoleFactory;
import com.fdmgroup.tradingplatform.dao.CurrentShareholderSharesRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;


/**
 * Servlet implementation class ViewRequest
 */

public class ViewPortfolio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger("ViewPortfolio");
	
	private CurrentShareholderSharesRAMDAO currentShareholderSharesRAMDAO = new CurrentShareholderSharesRAMDAO();
	private Set<CurrentShareholderShares> currentShareholderShares;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPortfolio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setDateHeader("Expires", 0); 
		response.setHeader("Pragma","no-cache");
		
		Person person = (Person) request.getSession().getAttribute("person");
		if(person == null){
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("TPLogin");
			requestDispatcher.forward(request, response);
		}
		else {
		
				try {
					currentShareholderShares = currentShareholderSharesRAMDAO.read(person.getPersonId());
				} catch (ClassNotFoundException e) {
					String error = "Nothing Found!";
					
					request.setAttribute("error", error);
					RequestDispatcher dispatcher = request.getRequestDispatcher("Loginfail");
					dispatcher.forward(request, response);
				}	
				request.setAttribute("currentshares", currentShareholderShares);

				log.info("Portfolio Viewed! " + person);

				RequestDispatcher dispatcher = request.getRequestDispatcher("PortfolioInfo");
				dispatcher.forward(request, response);
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
