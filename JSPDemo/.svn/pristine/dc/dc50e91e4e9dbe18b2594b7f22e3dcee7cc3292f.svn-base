package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showDayServlet
 */
@WebServlet("/showDay")

public class showDayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showDayServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> countries = new ArrayList<>();
		Map<Integer, String> names = new HashMap<>();
		
		Calendar cal = Calendar.getInstance();
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek ==1)
			dayOfWeek =7;
		else
			dayOfWeek--;
		countries.add("Canada");
		countries.add("USA");
		countries.add("UK");
		countries.add("Germany");
		countries.add("Italy");
		countries.add("Mexico");
		
		names.put(1,"Alex");
		names.put(2,"John");
		names.put(3,"Steve");
		names.put(4,"Chris");

		request.setAttribute("dayOfWeek", dayOfWeek);
		request.setAttribute("dayOfWeek", dayOfWeek);
		RequestDispatcher rd = request.getRequestDispatcher("showDay.jsp");
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
