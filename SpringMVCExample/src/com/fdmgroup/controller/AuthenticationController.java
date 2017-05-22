package com.fdmgroup.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.entity.User;

@Controller
@SessionAttributes(names={"user"}, types= {User.class})
public class AuthenticationController {
	
	@Autowired
	ApplicationContext appContext;
	
	
	@RequestMapping(value = "/loginform", method =RequestMethod.GET)
	public  ModelAndView showLoginForm(){
		User user = new User();
		ModelAndView mav= new ModelAndView("login");
		mav.addObject(user);
		return mav;
	}
	
	@RequestMapping(value="/processLogin", method = RequestMethod.POST)
	public String processLogin( Model model, @Valid User user,  BindingResult br, SessionStatus ss){
		
		if(br.hasErrors())
			return "login";
		
		UserDAO userDAO = (UserDAO)appContext.getBean("userDAO");
		User foundUser = userDAO.findByUsername(user.getUsername());
		
		if(foundUser != null && foundUser.getPassword().equals(user.getPassword())){
			foundUser.setInterests(user.getInterests());
			model.addAttribute("user",foundUser);
			return "welcome";
			
		}
		
		String errorMsg ="This is not the person we are looking for.";
		model.addAttribute("errorMsg",errorMsg );
		
		//ss.setComplete();

		return "login";
		//return "redirect:/loginForm";
	}
}
