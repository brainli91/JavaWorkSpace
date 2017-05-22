package com.fdmgroup.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@Autowired
	HttpServletRequest req;
	
	@RequestMapping(value="/home", method = {RequestMethod.GET,RequestMethod.POST})
	public String showWelcomePage() {
		//return "welcome";
		return "form";
		
	}
	
	@RequestMapping(value = "/process", method =RequestMethod.GET)
	public String processForm(Model model, @RequestParam String num1, @RequestParam(name ="num2") Integer number2){
/*		int n1 = Integer.parseInt(req.getParameter("num1"));
		int n2 = Integer.parseInt(req.getParameter("num2"));*/

		
		int numInt = Integer.parseInt(num1);
		int sum = numInt + number2;
		  model.addAttribute("sum", sum);
		
		System.out.println("Sum is: "+ sum);
		
		return "welcome";
		
	}
}
