package com.fdmgroup.tradingplatform.controllers;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.fdmgroup.tradingplatform.bin.EntityFactory;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.Role;
import com.fdmgroup.tradingplatform.bin.RoleFactory;
import com.fdmgroup.tradingplatform.bin.Trade;
import com.fdmgroup.tradingplatform.dao.TradeRAMDAO;

/**
 * Servlet implementation class ViewTrade
 */

public class ViewTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Set<Trade> trades = new HashSet<Trade>();
	private TradeRAMDAO tradeRAMDAO = new TradeRAMDAO();
	static Logger log = Logger.getLogger("ViewTrade");	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTrade() {
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
		
				trades = new HashSet<Trade>();
				tradeRAMDAO.setEmf(EntityFactory.getEmf());
				trades = tradeRAMDAO.read(person);
				
				request.setAttribute("trades", trades);
				request.setAttribute("tradenum", trades.size());

				log.info("Trade Viewed! " + person);

				RequestDispatcher dispatcher = request.getRequestDispatcher("AllTradeInfo");
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
