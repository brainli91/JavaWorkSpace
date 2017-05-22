package com.fdmgroup.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.fdmgroup.model.User;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User) WebUtils.getSessionAttribute(request, "user");
		if (user == null || !user.isActive()){
			response.sendRedirect(request.getServletContext().getContextPath() + "/login");
			return false;
		}
		return true;
	}
	
	
}
