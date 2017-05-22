package com.fdmgroup.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.fdmgroup.entity.User;

public class PatientInterceptor extends HandlerInterceptorAdapter{

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
			User user = (User) WebUtils.getSessionAttribute(request, "user");
			if (user.getRole().getName().equalsIgnoreCase("applicant")){
				return true;
			}
			
			response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard");
			return false;
		}
		
		
	}