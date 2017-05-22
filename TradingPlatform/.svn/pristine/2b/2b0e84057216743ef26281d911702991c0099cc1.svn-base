package com.fdmgroup.tradingplatform.servlet;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewLogServlet
 */
@WebServlet("/viewlog")
public class ViewLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewLogServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileReader fr = null;
		BufferedReader br = null;
		List<String> logs = new ArrayList<String>();

			fr = new FileReader("/Library/Tomcat/logs/syslog.log");
			br = new BufferedReader(fr);
			
			String line = "";

			while ((line = br.readLine()) != null) {
				logs.add(line);
			}

		request.setAttribute("logs", logs);
		RequestDispatcher rd = request.getRequestDispatcher("viewlogs.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, FileNotFoundException, IOException {
		doGet(request, response);
	}
}
