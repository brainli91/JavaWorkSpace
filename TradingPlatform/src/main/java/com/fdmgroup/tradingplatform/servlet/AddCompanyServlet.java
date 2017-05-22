package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.tradingplatform.databasedao.CompanyDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RequestDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.RoleDAO_JDBC;
import com.fdmgroup.tradingplatform.databasedao.UserDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Company;
import com.fdmgroup.tradingplatform.model.Request;
import com.fdmgroup.tradingplatform.model.Role;
import com.fdmgroup.tradingplatform.model.User;

/**
 * Servlet implementation class AddCompanyServlet
 */
@WebServlet("/addcompany")
public class AddCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCompanyServlet() {
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
		String companyname = request.getParameter("companyname");
		double price = Double.parseDouble(request.getParameter("price"));
		int sharecount = Integer.parseInt(request.getParameter("sharecount"));
		
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();
		RoleDAO_JDBC roleDAO = RoleDAO_JDBC.getInstance();
		UserDAO_JDBC userDAO = UserDAO_JDBC.getInstance();
		RequestDAO_JDBC requestDAO = RequestDAO_JDBC.getInstance();

		
		
		Company existingCompany = companyDAO.findByName(companyname);
		if (existingCompany != null) {
			request.setAttribute("companyexists", "Company named " + existingCompany.getName() + " already exists.");
			RequestDispatcher rd = request.getRequestDispatcher("addcompany.jsp");
			rd.forward(request, response);
			return;
		}
		Company company = new Company(companyname, price);
		Company createdCompany = companyDAO.create(company);
		

		if (createdCompany == null) {
			request.setAttribute("failcreate", "Failure creating New Company");
			RequestDispatcher rd = request.getRequestDispatcher("addcompany.jsp");
			rd.forward(request, response);
			return;
		}

		// Need to create a new user with the company role for new company//

		User newCompanyUser = new User();
		newCompanyUser.setUserName(companyname);
		newCompanyUser.setPassWord(companyname);
		newCompanyUser.setFirstName(companyname);
		newCompanyUser.setLastName(companyname);
		List<Role> listRoles = new ArrayList<Role>();
		Role companyRole = roleDAO.findRoleByRoleName("Company");
		listRoles.add(companyRole);
		newCompanyUser.setRoles(listRoles);
		User newCreatedCompanyUser = userDAO.create(newCompanyUser);
		if (newCreatedCompanyUser == null) {
			request.setAttribute("failcreate", "Failure creating user associated with new company");
			RequestDispatcher rd = request.getRequestDispatcher("addcompany.jsp");
			rd.forward(request, response);
			return;

		}

		// Need to create a new request to sell the new company's initial
		// shares, if any:
		if (sharecount != 0) {
			Request newCompanySellRequest = new Request();
			newCompanySellRequest.setCompany(createdCompany);
			newCompanySellRequest.setMinShares(0);
			newCompanySellRequest.setRequestDate(new Date(Calendar.getInstance().getTime().getTime()));
			newCompanySellRequest.setShareholder(newCompanyUser);
			newCompanySellRequest.setShareCount(sharecount);
			newCompanySellRequest.setSharesFilled(0);
			newCompanySellRequest.setStatus("ACTIVE");
			newCompanySellRequest.setTimeInForce("GOOD UNTIL CANCELLED");
			newCompanySellRequest.setType("SELL");
			if (requestDAO.create(newCompanySellRequest) == null) {
				request.setAttribute("failcreate", "Failure creating request to sell company initial shares.");
				RequestDispatcher rd = request.getRequestDispatcher("addcompany.jsp");
				rd.forward(request, response);
				return;
			}
		}
		request.setAttribute("failcreate", "Company created successfully");
		RequestDispatcher rd = request.getRequestDispatcher("addcompany.jsp");
		rd.forward(request, response);
	}

}
