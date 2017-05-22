package com.fdmgroup.tradingplatform.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	List<String> excludeURLs = new ArrayList<>();
    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		excludeURLs.add("/login");
		excludeURLs.add("login.jsp");
		System.out.println("AuthenticationFilter Initiated");
		
		}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("AuthenticationFilter destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(false);
		 if ((session != null && session.getAttribute("user") == null) && !excludeURLs.contains(httpReq.getServletPath())){
			RequestDispatcher rd = httpReq.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
			 
		 }
		chain.doFilter(request, response);
	}



}
