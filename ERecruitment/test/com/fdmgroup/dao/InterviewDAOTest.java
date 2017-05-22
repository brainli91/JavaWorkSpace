package com.fdmgroup.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fdmgroup.model.Interview;
import com.fdmgroup.model.InterviewType;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.JobApplication;
import com.fdmgroup.model.Role;
import com.fdmgroup.model.User;

@FixMethodOrder(MethodSorters.JVM)
public class InterviewDAOTest {


  static DBConnection dbConnection = new DBConnection();
  static InterviewDAO interviewDAO = new InterviewDAO();
  
  Calendar cal = Calendar.getInstance();
  Date oldDate = new Date(0);
  Date currDate = null;
  Interview interview1;
  Interview interview2;
  List<Interview> interviewList = new ArrayList<Interview>();
  User user1 = new User("123@fmd.com", "123", "george", "lai", new Role(1, "admin"));
  User user2 = new User("123@fmd.com", "123", "george", "lai", new Role(2, "staff"));
  User user3 = new User("123@fmd.com", "123", "george", "lai", new Role(3, "applicant"));
  User user4 = new User("123@fmd.com", "123", "george", "lai", new Role(4, "recruiter"));

  @BeforeClass
  public static void setUpBeforeClass() {
    interviewDAO.setDbConnection(dbConnection);
  }

  @Before
  public void setUp() {
    interview1 = new Interview(InterviewType.ONLINE, oldDate);
    interview2 = new Interview(InterviewType.PHONE, oldDate);
    interview1.setId(1);
    interview2.setId(2);
    interviewList.add(interview1);
    interviewList.add(interview2);
    
    cal.set(2016, Calendar.NOVEMBER, 12);
    currDate = new Date(cal.getTimeInMillis());
  }	

  @Test
  public void createTest() {
	  Interview newInterview = new Interview(InterviewType.ONLINE, oldDate);
	  Interview createdInterview = interviewDAO.create(newInterview);
	  assertNotNull(createdInterview);
  }

  @Test
  public void readTest() {
    Interview readInterview = interviewDAO.read(1L);
    System.out.println(readInterview);
    assertNotNull(readInterview);
  }

  @Test
  public void findAllTest(){
	  assertNotNull(interviewDAO.findAll());
  }
  
  @Test
  public void testFindCurrentInterviews_ReturnListOfCurrentInterviews(){
	  Interview currInterview = new Interview(InterviewType.PHONE, currDate);
	  interviewDAO.create(currInterview);
	  assertNotNull(interviewDAO.findCurrentInterviews().isEmpty());
  }
  
  @Test
  public void testFindInterviewByAdmin(){
	  
	  assertEquals(null, interviewDAO.findUserInterviews(user1));
  }
  
  @Test
  public void testFindInterviewByApplicant(){
	  Set<JobApplication> jobApplications = new HashSet<>();
	  JobApplication ja1 = new JobApplication(user3, new Job("aa", "aa", oldDate, oldDate, "aa", 3, user2));
	  Set<Interview> si1 = new HashSet<>();
	  si1.add(interview1);
	  ja1.setInterviews(si1);
	  jobApplications.add(ja1);
	  user3.setJobApplications(jobApplications);
	  interview1.setJobApplication(ja1);
	  
	  Set<Interview> setOfInterview = new HashSet<>();
	  setOfInterview.add(interview1);
	  assertEquals(setOfInterview, interviewDAO.findUserInterviews(user3));
  }

  @Test
  public void testFindInterviewByRecruiter(){
	  Job job1 = new Job("abc", "def", oldDate, oldDate, "abc", 2, user4);
	  Job job2 = new Job("abcdef", "gh", oldDate, oldDate, "abc", 3, user4);
	  
	  Set<Job> setOfJobs = new HashSet<>();
	  setOfJobs.add(job1);
	  setOfJobs.add(job2);
	  user4.setCreatedJobs(setOfJobs);
	  Set<JobApplication> jobApplications = new HashSet<>();
	  job1.setJobApplications(jobApplications);
	  
	  JobApplication ja1 = new JobApplication(user3, job1);
	  
	  Set<Interview> si1 = new HashSet<>();
	  si1.add(interview1);
	  ja1.setInterviews(si1);
	  jobApplications.add(ja1);
	  user3.setJobApplications(jobApplications);
	  interview1.setJobApplication(ja1);
	  
	  Set<Interview> setOfInterview = new HashSet<>();
	  setOfInterview.add(interview1);
	  assertEquals(setOfInterview, interviewDAO.findUserInterviews(user4));
  }
  
}
