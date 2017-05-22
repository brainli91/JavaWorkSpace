package com.fdmgroup.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.dao.BasketDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.entity.User;



@Controller
@SessionAttributes(names = {"user"}, types = { User.class})
public class ShoppingCartController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	BasketDAO basketDAO;
	
	@Autowired
	HttpServletRequest request;
	
	

}
