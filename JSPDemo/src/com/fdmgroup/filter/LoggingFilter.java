package com.fdmgroup.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter("/*")
public class LoggingFilter implements Filter {
	
	Logger logger  =null;
	
    /**
     * Default constructor. 
     */
    public LoggingFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Logging filter destroyed");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		String ip = request.getRemoteAddr();
		HttpServletRequest httpReq =(HttpServletRequest) request;
		String uri =httpReq.getRequestURI();
		
		logger.info(ip + "-->"+ uri);
		
		chain.doFilter(request, response);
	}	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	    logger = Logger.getLogger("sysLogger");
		System.out.println("Logging filter Initiated");
	}

}
