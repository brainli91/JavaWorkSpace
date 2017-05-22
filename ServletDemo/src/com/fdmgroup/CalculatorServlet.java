package com.fdmgroup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet(value ="/calculator", initParams = {
		@WebInitParam(name="num1", value="30"),
		@WebInitParam(name="num2", value="40")
})
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
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

		//doGet(request, response);
		PrintWriter out = response.getWriter();
/*		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");*/
		int num1 =(int) request.getAttribute("num1");
		int num2 = (int)request.getAttribute("num2");
		/*
		if (num1 == null ||num1.isEmpty())
			num1 = getInitParameter("num1");
		if (num2 == null || num2.isEmpty())
			num2 = getInitParameter("num2");
		int sum = Integer.parseInt(num1) + Integer.parseInt(num2);*/
		
		int sum = num1  + num2;
		
		out.println("<html>"
				+ "<body>"
				+ "<p> The sum of "+ num1 +" and "+ num2 +" is: <strong>"+ sum +"</strong>"
				+ "</body>"
				+ "</html>");
	}

}
