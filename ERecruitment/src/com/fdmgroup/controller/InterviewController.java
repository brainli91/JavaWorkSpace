package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.dao.InterviewDAO;
import com.fdmgroup.dao.JobDAO;
import com.fdmgroup.model.Interview;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.User;

@Controller
@SessionAttributes(names = { "user" }, types = { User.class })
public class InterviewController {

  @Autowired
  @Qualifier("interviewDAO")
  InterviewDAO interviewDAO;

  @Autowired
  @Qualifier("jobDAO")
  JobDAO jobDAO;

  public InterviewController() {
    // TODO Auto-generated constructor stub
  }

  @RequestMapping(value = "/viewInterviewByJob", method = RequestMethod.GET)
  public String viewInterviewsByJob(Model model, @RequestParam String jobId) {
    Integer id = Integer.parseInt(jobId);
    Job job = jobDAO.read(id);
    Set<Interview> interviews = null;// job.getInterviews();
    ArrayList<Interview> listofinterviews = new ArrayList<Interview>(interviews);
    model.addAttribute("interviews", listofinterviews);
    return "view_interviews";
  }

  /*
  @RequestMapping(value = "/viewInterviewByUserID", method = RequestMethod.GET)
  public String viewInterviewsByApplicant(Model model,  @ModelAttribute User user) {
  	Set<Job> jobs = user.getCreatedJobs();

  }

  @RequestMapping(value = "/createInterview", method = RequestMethod.POST)
  public String createInterview() {
  	return null;
  }

  @RequestMapping(value = "/updateInterview", method = RequestMethod.POST)
  public String createInterview() {
  	return null;
  }
  	*/
}
