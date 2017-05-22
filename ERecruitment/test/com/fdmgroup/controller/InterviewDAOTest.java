package com.fdmgroup.controller;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import com.fdmgroup.dao.DBConnection;
import com.fdmgroup.dao.InterviewDAO;
import com.fdmgroup.model.ApplicantProfile;
import com.fdmgroup.model.Interview;
import com.fdmgroup.model.InterviewResult;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.User;

public class InterviewDAOTest {

  @Mock
  User user;

  @Mock
  InterviewResult interviewResult;

  @Mock
  Job job;

  @Mock
  ApplicantProfile appProfile;

  static DBConnection dbConnection = new DBConnection();
  Date date = new Date(0);
  static InterviewDAO interviewDAO = new InterviewDAO();

  Interview interview;
  List<Job> jobList = new ArrayList<Job>();

  @BeforeClass
  public static void setUpBeforeClass() {
    interviewDAO.setDbConnection(dbConnection);
  }

  @Before
  public void setUp() {
    interview = new Interview();
  }

  @Test
  @Ignore
  public void createTest() {
    Interview createdInterview = interviewDAO.create(interview);
    assertEquals(interview, createdInterview);
  }

  @Test
  @Ignore
  public void readTest() {
    interviewDAO.create(interview);
    Interview readInterview = interviewDAO.read(1L);
    System.out.println(readInterview);
    assertEquals(interview, readInterview);
  }

}
