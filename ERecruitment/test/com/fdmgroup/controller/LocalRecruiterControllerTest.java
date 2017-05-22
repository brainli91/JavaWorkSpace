// THIS IS JUST FOR TESTING PURPOSES

package com.fdmgroup.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.model.ApplicantProfile;
import com.fdmgroup.model.Interview;
import com.fdmgroup.model.InterviewType;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.JobApplication;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

@Controller
@SessionAttributes(names = { "user" }, types = { User.class })
public class LocalRecruiterControllerTest {

  /*  @Autowired
  UserDAO userDAO;
  
  @Autowired
  RoleDAO roleDAO;*/

  static Role r1 = new Role(1L, "applicant");
  static User u1 = new User("yu.lai.fdmgroup.com", "12345", "Yu", "Lai", r1);
  static User u2 = new User("yu.lai2.fdmgroup.com", "123456", "Yu2", "Lai2", r1);

  public LocalRecruiterControllerTest() {

    /*    roleDAO.create(r1);
    userDAO.create(u1);
    userDAO.create(u2);*/
  }

  @RequestMapping(value = "/createJobTest", method = RequestMethod.GET)
  public String showCreateJobTestPage(Model model) {

    model.addAttribute("user", u1);
    model.addAttribute("job", new Job());
    return "create_job";
  }

  @RequestMapping(value = "/viewJobTest", method = RequestMethod.GET)
  public String showViewJobTestPage(Model model) {

    Job job = new Job();
    job.setDeadlineDate(new Date(Calendar.getInstance().getTimeInMillis()));
    job.setDescription("This job sucks");
    job.setTitle("SQL Developer");
    job.setKeywords("SQL, UNIX, Java");
    job.setNumOfPositions(5);
    job.setStartDate(new Date(Calendar.getInstance().getTimeInMillis()));

    List<User> applicants = new ArrayList<>();
    applicants.add(u1);
    applicants.add(u2);

    u1.setApplicantProfile(
        new ApplicantProfile(u1, "123 Toronto St.", "123-456-7890", null, "Hearthstone", "Java; SQL; C++", null, null));
    u2.setApplicantProfile(
        new ApplicantProfile(u2, "456 Toronto St.", "999-999-9999", null, "Games", "None :(", null, null));

    JobApplication ja1 = new JobApplication(u1, job);
    JobApplication ja2 = new JobApplication(u2, job);
    JobApplication ja3 = new JobApplication(u1, job);
    ja1.setScore(60);
    ja2.setScore(55);
    ja3.setScore(95);
    job.getJobApplications().add(ja1);
    job.getJobApplications().add(ja2);
    job.getJobApplications().add(ja3);

    model.addAttribute("job", job);
    return "view_job";
  }

  @RequestMapping(value = "/createInterviewTest", method = RequestMethod.GET)
  public String showCreateInterviewTestPage(Model model) {
    // model.addAttribute("application", new JobApplication());

    // Set the jobApplication field of interview here

    List<User> staffs = new ArrayList<User>(Arrays.asList(u1, u2));

    model.addAttribute("staffs", staffs);

    model.addAttribute("interview", new Interview());
    return "create_interview";
  }

  @RequestMapping(value = "/viewInterviewsTest", method = RequestMethod.GET)
  public String showViewInterviewsTestPage(Model model) {

    Job job = new Job();
    job.setDeadlineDate(new Date(Calendar.getInstance().getTimeInMillis()));
    job.setDescription("This job sucks");
    job.setTitle("SQL Developer");
    job.setKeywords("SQL, UNIX, Java");
    job.setNumOfPositions(5);
    job.setStartDate(new Date(Calendar.getInstance().getTimeInMillis()));

    JobApplication ja1 = new JobApplication(u1, job);

    Interview i1 = new Interview(InterviewType.PHONE, new Date(Calendar.getInstance().getTimeInMillis()));
    Interview i2 = new Interview(InterviewType.IN_PERSON, new Date(Calendar.getInstance().getTimeInMillis() + 100));
    Interview i3 = new Interview(InterviewType.ASSESSMENT, new Date(Calendar.getInstance().getTimeInMillis() + 500));

    i1.setId(1L);
    i2.setId(2L);
    i3.setId(3L);

    ja1.setInterviews(new HashSet<Interview>(Arrays.asList(i1, i2, i3)));

    model.addAttribute("jobApplication", ja1);

    // Set the jobApplication field of interview here
    return "view_interviews";
  }
}
