package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fdmgroup.dao.ApplicantProfileDAO;
import com.fdmgroup.dao.InterviewDAO;
import com.fdmgroup.dao.JobApplicationDAO;
import com.fdmgroup.dao.JobDAO;
import com.fdmgroup.dao.RoleDAO;
import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.ApplicationStatus;
import com.fdmgroup.model.Interview;
import com.fdmgroup.model.InterviewResult;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.JobApplication;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

@Controller
@SessionAttributes(names = { "user" }, types = { User.class })
public class RecruiterController {

  @Autowired
  /*@Qualifier("jobDAO")*/
  JobDAO jobDAO;

  @Autowired
  ApplicantProfileDAO applicantProfileDAO;

  @Autowired
  UserDAO userDAO;

  @Autowired
  RoleDAO roleDAO;

  @Autowired
  InterviewDAO interviewDAO;

  @Autowired
  JobApplicationDAO jobAppDAO;

  @RequestMapping(value = "/recruiterView", method = { RequestMethod.GET, RequestMethod.POST })
  public String displayRecruiterDashboard(Model model, @ModelAttribute User user) {
    List<Job> recruiterJobs = new ArrayList<>(user.getCreatedJobs());
    recruiterJobs.sort(Job.sortByID);
    Collections.reverse(recruiterJobs);
    model.addAttribute("recruiterJobs", recruiterJobs.subList(0, Math.min(5, recruiterJobs.size())));

    List<Interview> recruiterInterviews = interviewDAO.findUserInterviews(user);
    List<Interview> pendingInterviews = new ArrayList<>();
    for (Interview interview : recruiterInterviews) {
      if (interview.getResult() == InterviewResult.PENDING) {
        pendingInterviews.add(interview);
      }
    }
    pendingInterviews.sort(Interview.sortByDate);
    Collections.reverse(pendingInterviews);
    model.addAttribute("recruiterInterviews", pendingInterviews.subList(0, Math.min(5, pendingInterviews.size())));

    return "recruiter_dashboard";
  }

  @RequestMapping(value = "/createOrEditJobView", method = RequestMethod.GET)
  public String createOrEditJob(Model model, @ModelAttribute User user, @RequestParam("jobId") String jobId) {
    Job job = null;

    if (jobId == null || jobId.equals("") || jobId.equals("0")) {
      job = new Job();
      job.setJobPoster(user);
    } else {
      long id = Long.parseLong(jobId);
      job = jobDAO.read(id);

      if (job == null) {
        model.addAttribute("errorMsg", "Job does not exist.");
        return "view_all_jobs";
      }
    }

    model.addAttribute("job", job);
    return "create_job";
  }

  @RequestMapping(value = "/postJob", method = RequestMethod.POST)
  public String postJob(Model model, @ModelAttribute User user, @Valid Job job, BindingResult br,
      @RequestParam("jobId") String jobId) {
    if (br.hasErrors()) {
      return "recruiter_dashboard";
    } else {
      boolean isUpdate = false;
      Job createdJob = null;
      job.setJobPoster(user);
      if (jobId == null || jobId.isEmpty() || jobId.equals("0")) {
        createdJob = jobDAO.create(job);
        user.getCreatedJobs().add(createdJob);
      } else {
        isUpdate = true;
        job.setId(Long.parseLong(jobId));
        Job storedJob = jobDAO.read(job.getId());
        job.setJobApplications(storedJob.getJobApplications());
        createdJob = jobDAO.update(job);
      }

      if (createdJob != null) {
        model.addAttribute("createdJob", createdJob);
        if (isUpdate) {
          model.addAttribute("successMessage", "Job Edited!");
        } else {
          model.addAttribute("successMessage", "Job Created!");
        }
        return "forward:/recruiterView";
      } else {
        model.addAttribute("errorMessage", "Job creation failed");
        model.addAttribute("job", job);
        return "create_job";
      }
    }
  }

  @RequestMapping(value = "/recruiterViewJob", method = RequestMethod.GET)
  public String recruiterViewJob(Model model, @RequestParam("jobId") String jobId) {
    long id = Long.parseLong(jobId);
    Job job = jobDAO.read(id);
    model.addAttribute("job", job);
    return "view_job";
  }

  @RequestMapping(value = "/viewApplicantProfile", method = RequestMethod.GET)
  public String viewJobApplicantProfile(Model model, @RequestParam("applicant") String applicant) {
    long id = Long.parseLong(applicant);
    User userApplicant = userDAO.read(id);

    if (userApplicant != null) {
      model.addAttribute("applicant", userApplicant);
      return "view_applicant";
    } else {
      model.addAttribute("errorMsg", "Error: User does not exist.");
      return "error_page";
    }

  }

  @RequestMapping(value = "/recruiterViewInterviews", method = RequestMethod.GET)
  public String viewRecruiterInterviews(Model model, @ModelAttribute User user) {
    List<Interview> interviewList = interviewDAO.findUserInterviews(user);
    if (interviewList.size() == 0 || interviewList == null) {
      model.addAttribute("msg", "Nothing to display");
    }
    model.addAttribute("interviews", interviewList);
    return "view_all_interviews";
  }

  @RequestMapping(value = "/jobApplicationViewInterviews", method = RequestMethod.GET)
  public String viewJobApplicationInterviews(Model model, @RequestParam("application") String application) {
    long id = Long.parseLong(application);
    JobApplication jobApp = jobAppDAO.read(id);
    if (jobApp == null) {
      model.addAttribute("errorMsg", "Application does not exist.");
      return "view_interviews";
    } else {
      Set<Interview> interviews = jobApp.getInterviews();
      model.addAttribute("jobApplication", jobApp);
      model.addAttribute("jobInterviews", interviews);

      return "view_interviews";
    }
  }

  @RequestMapping(value = "/viewStatistics", method = RequestMethod.GET)
  public String loadRecruiterStatistics(Model model, @ModelAttribute User user) {
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

    List<Interview> userInterviews = interviewDAO.findUserInterviews(user);
    HashMap<String, Integer> interviewResultCount = new HashMap<>();
    HashMap<String, Integer> interviewTypeCount = new HashMap<>();
    for (Interview interview : userInterviews) {
      String resultName = interview.getResult().getName();
      String typeName = interview.getType().getName();
      Integer resultCount = interviewResultCount.getOrDefault(resultName, 0);
      Integer typeCount = interviewTypeCount.getOrDefault(typeName, 0);
      interviewResultCount.put(resultName, resultCount + 1);
      interviewTypeCount.put(typeName, typeCount + 1);
    }
    model.addAttribute("interviewResultCount", interviewResultCount);
    model.addAttribute("interviewTypeCount", interviewTypeCount);

    return "view_statistics";
  }

  @RequestMapping(value = "/addOrEditInterview", method = RequestMethod.GET)
  public String addOrEditInterview(Model model, @ModelAttribute User user,
      @RequestParam("interviewId") String interviewId, @RequestParam("jobAppId") String jobAppId) {
    Interview interview = null;
    List<User> staffs = new ArrayList<>();

    if (interviewId == null || interviewId.equals("")) {
      interview = new Interview();
    } else {
      long id = Long.parseLong(interviewId);
      interview = interviewDAO.read(id);
      if (interview == null) {
        model.addAttribute("errorMsg", "Interview does not exist.");
        return "forward:recruiterViewInterviews";
      }
    }

    boolean jobAppFound = true;
    JobApplication jobApp = null;
    if (jobAppId == null || jobAppId.equals("")) {
      jobAppFound = false;
    } else {
      jobApp = jobAppDAO.read(Long.parseLong(jobAppId));
      if (jobApp == null) {
        jobAppFound = false;
      }
    }
    if (!jobAppFound) {
      model.addAttribute("errorMsg", "Job application does not exist.");
      return "forward:recruiterViewInterviews";
    }
    if (user != jobApp.getJob().getJobPoster()) {
      model.addAttribute("application", jobAppId);
      model.addAttribute("errorMsg", "You do not have permission for this job application.");
      return "forward:jobApplicationViewInterviews";
    }

    interview.setJobApplication(jobApp);

    model.addAttribute("jobAppId", jobAppId);
    model.addAttribute("interview", interview);

    List<User> allUsers = userDAO.findAll();
    for (User staff : allUsers) {
      if (staff != null && staff.getRole() != null && staff.getRole().getName() != null
          && staff.getRole().getName().equals("staff"))
        staffs.add(staff);
    }
    model.addAttribute("staffs", staffs);

    return "create_interview";
  }

  @RequestMapping(value = "/addOrEditInterview", method = RequestMethod.POST)
  public String addOrEditInterview(Model model, Interview interview, @RequestParam String jobAppId,
      @RequestParam String interviewId) {
    Interview iview = null;

    model.addAttribute("application", jobAppId);
    model.addAttribute("interviewId", interview.getId());

    JobApplication jobApp = jobAppDAO.read(Long.parseLong(jobAppId));
    if (jobApp == null) {
      model.addAttribute("errorMsg", "Job application does not exist");
      return "forward:recruiterViewInterviews";
    }
    interview.setJobApplication(jobApp);
    Set<Interview> interviews = jobApp.getInterviews();
    if (interviews == null) {
      interviews = new HashSet<>();
      jobApp.setInterviews(interviews);
    }
    interviews.add(interview);
    if (interviewId == null || interviewId.isEmpty() || interviewId.equals("0")) {
      iview = interviewDAO.create(interview);
    } else {
      interview.setId(Long.parseLong(interviewId));
      iview = interviewDAO.update(interview);
    }

    if (iview != null) {
      model.addAttribute("successMsg", "Interview successfully scheduled");
    } else {
      model.addAttribute("errorMsg", "Interview cannot be scheduled");
      return "create_interview";
    }

    model.addAttribute("newInterview", interview);
    return "redirect:jobApplicationViewInterviews";
  }

  @RequestMapping(value = "/viewAllRecruiterJobs", method = RequestMethod.GET)
  public String viewAllRecruiterJobs(Model model, @ModelAttribute User user) {
    List<Job> recruiterJobs = new ArrayList<>(user.getCreatedJobs());
    recruiterJobs.sort(Job.sortByID);
    Collections.reverse(recruiterJobs);
    model.addAttribute("recruiterJobs", recruiterJobs);
    return "view_all_jobs";
  }

  @RequestMapping(value = "/viewAllJobs", method = RequestMethod.GET)
  public String viewAllJobs(Model model, @ModelAttribute User user) {
    List<Job> allJobs = jobDAO.findAll();
    allJobs.sort(Job.sortByID);
    Collections.reverse(allJobs);
    model.addAttribute("jobs", allJobs);
    return "view_all_jobs_recruiter";
  }

  @RequestMapping(value = "/jobApplicationAcceptApplicant", method = RequestMethod.GET)
  public String acceptApplicant(Model model, User user, @RequestParam String jobId,
      @RequestParam("application") String appID) {
    Integer appIDi = 0;
    try {
      appIDi = Integer.parseInt(appID);
    } catch (NumberFormatException e) {
      model.addAttribute("errorMSG", "Job Application ID does not exist");
      return "redirect:dashboard";
    }

    JobApplication jobApp = jobAppDAO.read(appIDi);
    Job job = jobApp.getJob();

    int acceptedApplications = 0;
    Set<JobApplication> jobApps = job.getJobApplications();
    for (JobApplication ajobApp : jobApps) {
      if (ajobApp.getStatus().equals(ApplicationStatus.ACCEPTED)) {
        acceptedApplications++;
      }
    }

    if (acceptedApplications >= job.getNumOfPositions()) {
      model.addAttribute("errorMsg", "The job is full. It already has " + job.getNumOfPositions() + " Applicant(s)");
    } else {
      jobApp.setStatus(ApplicationStatus.ACCEPTED);
      jobApp = jobAppDAO.update(jobApp);
      if (jobApp == null) {
        model.addAttribute("errorMsg", "Error Accepting Applicant");
      } else {
        model.addAttribute("successMsg",
            jobApp.getApplicant().getFirstName() + " " + jobApp.getApplicant().getLastName() + " Accepted");
      }
    }

    return "forward:/recruiterViewJob";
  }

  @RequestMapping(value = "/jobApplicationRejectApplicant", method = RequestMethod.GET)
  public String rejectApplicant(Model model, User user, @RequestParam String jobId,
      @RequestParam("application") String appID) {
    Integer appIDi = 0;
    try {
      appIDi = Integer.parseInt(appID);
    } catch (NumberFormatException e) {
      model.addAttribute("errorMsg", "Job Application ID does not exist");
      return "redirect:dashboard";
    }
    JobApplication jobApp = jobAppDAO.read(appIDi);
    jobApp.setStatus(ApplicationStatus.REJECTED);
    jobApp = jobAppDAO.update(jobApp);
    if (jobApp == null) {
      model.addAttribute("errorMsg", "Error REJECTING Applicant");
    } else {
      model.addAttribute("successMsg",
          jobApp.getApplicant().getFirstName() + " " + jobApp.getApplicant().getLastName() + " Rejected");
    }

    return "forward:/recruiterViewJob";
  }
}
