package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.tradingplatform.databasedao.CompanyDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RequestDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Request;

/**
 * Servlet implementation class SellRequestServlet
 */
@WebServlet("/sellrequest")
public class SellRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellRequestServlet() {
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
		String userName = request.getParameter("username");
		String companyName = request.getParameter("companyname");
		int shareCount = Integer.parseInt(request.getParameter("numshare"));
		
		RequestDAO_JDBC requestDAO = RequestDAO_JDBC.getInstance();
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		
		if(companyDAO.findByName(companyName)==null){
			request.setAttribute("nomatchcompany", "Please Enter the correct company name!");
			RequestDispatcher rd = request.getRequestDispatcher("buyrequest.jsp");
			rd.forward(request, response);
			return;
		}
		
		Request sellRequest = new Request();
		
		sellRequest.setCompany(companyDAO.findByName(companyName));
		sellRequest.setRequestDate(new Date(Calendar.getInstance().getTime().getTime()));
		sellRequest.setShareholder(userDAO.findByUserName(userName));
		sellRequest.setShareCount(shareCount);
		sellRequest.setMinShares(0);
		sellRequest.setTimeInForce("GOOD UNTIL CANCELLED");
		sellRequest.setStatus("ACTIVE");
		sellRequest.setType("SELL");
		
		if (requestDAO.create(sellRequest) != null) {
			requestDAO.processRequest();
			request.setAttribute("sendbuymsg", "Request Sent");
			RequestDispatcher rd = request.getRequestDispatcher("viewportfolio");
			rd.forward(request, response);
			return;
		} else {
			request.setAttribute("sendbuymsg", "An error occurred while processing your request. Please try again.");
			RequestDispatcher rd = request.getRequestDispatcher("sellrequest.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

}
