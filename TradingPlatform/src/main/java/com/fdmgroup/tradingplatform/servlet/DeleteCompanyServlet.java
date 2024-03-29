package com.fdmgroup.tradingplatform.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.tradingplatform.databasedao.CompanyDAO_JDBC;
import com.fdmgroup.tradingplatform.model.Company;

/**
 * Servlet implementation class DeleteCompanyServlet
 */
@WebServlet("/deletecompany")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCompanyServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String companyname= request.getParameter("companyname");
		CompanyDAO_JDBC companyDAO = CompanyDAO_JDBC.getInstance();
		
		
		Company targetCompany = companyDAO.findByName(companyname);

		if (targetCompany == null) {
			request.setAttribute("companynotexists", "Company not found");
			RequestDispatcher rd = request.getRequestDispatcher("deletecompany.jsp");
			rd.forward(request, response);
			return;
		}
		boolean deleted = companyDAO.delete(targetCompany);
		if (!deleted) {
			request.setAttribute("deletemsg", "An error occured while processing your request. Please try again");
			RequestDispatcher rd = request.getRequestDispatcher("deletecompany.jsp");
			rd.forward(request, response);
			return;
		} else {
			request.setAttribute("deletemsg", "Company deleted successfully");
			RequestDispatcher rd = request.getRequestDispatcher("deletecompany.jsp");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
