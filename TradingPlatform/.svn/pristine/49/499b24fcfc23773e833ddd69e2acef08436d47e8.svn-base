package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.tradingplatform.databasedao.CompanyDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RequestDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.TradeDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.User;

/**
 * Servlet implementation class ViewPortfolioServlet
 */
@WebServlet("/viewportfolio")
public class ViewPortfolioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TradeDAO_JDBC TradeDAO = TradeDAO_JDBC.getInstance();
	private CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC
			.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPortfolioServlet() {
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
		PrintWriter out = response.getWriter();
		User user = (User)request.getSession().getAttribute("user");

		user.setPortfolio(TradeDAO.portfolioForUser(user.getUserName()));
		//List<Request> requests = RequestDAO_JDBC.getInstance().findRequestByUserName(user.getUserName());
		HashMap<Company,Integer> portfolio = new HashMap<>();
		
			
		for (Integer key : user.getPortfolio().keySet()) {
			portfolio.put(companyDAO.findByStockId(key),user.getPortfolio().get(key));
			}
		
		if (portfolio.isEmpty()){
			request.setAttribute("noshares", "No Shares Owned. ");
			RequestDispatcher rd = request.getRequestDispatcher("viewportfolio.jsp");
			rd.forward(request, response);
			return;
		}
			
			
		
		request.setAttribute("portfolio", portfolio);
		
		RequestDispatcher rd = request.getRequestDispatcher("viewportfolio.jsp");
		rd.forward(request, response);
		return;
	}

}
