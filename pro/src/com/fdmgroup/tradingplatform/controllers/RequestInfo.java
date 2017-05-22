package com.fdmgroup.tradingplatform.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;

import com.fdmgroup.tradingplatform.bin.Company;
import com.fdmgroup.tradingplatform.bin.EntityFactory;
import com.fdmgroup.tradingplatform.bin.Person;
import com.fdmgroup.tradingplatform.bin.Request;
import com.fdmgroup.tradingplatform.bin.Role;
import com.fdmgroup.tradingplatform.bin.RoleFactory;
import com.fdmgroup.tradingplatform.dao.CompanyRAMDAO;
import com.fdmgroup.tradingplatform.dao.LogRAMDAO;
import com.fdmgroup.tradingplatform.dao.RequestRAMDAO;

/**
 * Servlet implementation class RequestInfo
 */

public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger("RequestInfo");	
	
	private RequestRAMDAO requestRAMDAO = new RequestRAMDAO();
	private CompanyRAMDAO companyRAMDAO = new CompanyRAMDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestInfo() {
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
			
		response.setHeader("Cache-Control","no-cache"); 
		response.setHeader("Cache-Control","no-store"); 
		response.setDateHeader("Expires", 0); 
		response.setHeader("Pragma","no-cache");
			
		String buyorsell = request.getParameter("buyorsell");
		String stockId = request.getParameter("stockid");
		String shares = request.getParameter("shares");
		String minimum = request.getParameter("minimum");
		String timeinforce = request.getParameter("timeinforce");
		String limitprice = request.getParameter("limitprice");
		String stopprice = request.getParameter("stopprice");		
		BigDecimal lp, sp;
		
		Person person = (Person) request.getSession().getAttribute("person");
		requestRAMDAO.setEmf(EntityFactory.getEmf());
		companyRAMDAO.setEmf(EntityFactory.getEmf());
		request.getSession().setAttribute("message", "Request Made!");
		
		if(limitprice.equals("null")){
			lp = null;
		}
		else {
			lp= new BigDecimal(limitprice);
		}
		
		if(limitprice.equals("null")){
			sp = null;
		}
		else {
			sp= new BigDecimal(stopprice);	
		}		
		
		Company company = companyRAMDAO.readByStockId( Integer.parseInt(stockId));
		Set<Role> roles =  person.getRoles();
		for (Role role : roles){
			Date time = new Date();
			role.setRoleFactory(new RoleFactory());
			role.getMakeRequest().setRequestRAMDAO(requestRAMDAO);
			Request marequest = role.getMakeRequest().makeRequest(0, null, 0, person, time,
					buyorsell, "ACTIVE", company, Integer.parseInt(shares), Integer.parseInt(minimum), timeinforce, lp, sp);
			
			log.info("Request Made! " + marequest);

			request.getSession().setAttribute("request", marequest);
			response.sendRedirect("Requestsuccess");
		}
	}

}
