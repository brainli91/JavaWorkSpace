package com.fdmgroup.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.dao.JobDAO;
import com.fdmgroup.dao.RoleDAO;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;



@Controller
@SessionAttributes(names = { "user" }, types = { User.class })
public class ManagerController {
	
	@Autowired
	JobDAO jobDAO;

	@Autowired
	RoleDAO roleDAO;
	
	@RequestMapping(value="/managerDashboard", method = RequestMethod.GET)
	 public String loadDashboard(Model model, @ModelAttribute User user) {
	    HashMap<String, Integer> postJobCount = new HashMap<>();

	    Role role = roleDAO.findByName("recruiter");

	    for (User recruiter : role.getUsers()) {
	      int sum = 0;
	      for (Job job : jobDAO.findByPoster(recruiter)) {
	        sum += job.getNumOfPositions();
	      }

	      if (sum != 0) {
	        postJobCount.put(recruiter.getFullName(), sum);
	      }
	    }

	    model.addAttribute("postJobCount", postJobCount);

	    return "manager_dashboard";
	  }
}
